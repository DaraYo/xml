package xml.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.io.JAXBHandle;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.MatchLocation;
import com.marklogic.client.query.MatchSnippet;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;
import com.marklogic.client.query.StructuredQueryBuilder;
import com.marklogic.client.query.StructuredQueryDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import xml.model.Author;
import xml.model.User;
import xml.security.TokenUtils;
import xml.web.dto.AuthorDTO;
import xml.web.dto.LoginDTO;
import xml.web.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private DatabaseClient client;

	@Autowired
	private XMLDocumentManager xmlDocumentManager;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private QueryManager queryManager;

	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);

	public static final String COLLECTION_REF = "/users";

	private static String jaxbObjectToXML(Author author) {// marshaller, iz objektnog u xml
		String xmlString = "";
		try {
			JAXBContext context = JAXBContext.newInstance(Author.class);
			Marshaller m = context.createMarshaller();
			m.setProperty("com.sun.xml.bind.namespacePrefixMapper",
					new NSPrefixMapper("http://www.uns.ac.rs/user", "usr"));
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);// To
																			// format
																			// XML
			StringWriter sw = new StringWriter();
			m.marshal(author, sw);
			xmlString = sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return xmlString;
	}

	public Author xmlTojaxbObject(String uname) {// unmarshaller, iz xml u objektni
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();
		System.out.println("XML to JAX object");

		String docId = "/users/" + uname + ".xml";

		Author author = new Author();
		try {
			JAXBContext context = JAXBContext.newInstance(Author.class);
			JAXBHandle<Author> handle = new JAXBHandle<Author>(context);
			xmlDocumentManager.read(docId, metadata, handle);

			author = handle.get();
			// Unmarshaller unmarshaller = context.createUnmarshaller();

			// Unmarshalling generi�e objektni model na osnovu XML fajla
			// u = (User) unmarshaller.unmarshal(resultsDocument);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		// client.release();

		return author;

	}

	// @SuppressWarnings("deprecation")
	public void register(AuthorDTO authorDTO)
			throws ParserConfigurationException, IOException {
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();
		metadata.getCollections().add(COLLECTION_REF);
		// Create a document manager to work with XML files.
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Author author = new Author();

		author.setUsername(authorDTO.getUsername());
		author.setPassword(encoder.encode(authorDTO.getPassword()));
		System.out.println(authorDTO.getEmail());
		author.setEMail(authorDTO.getEmail());
		author.setName(authorDTO.getName());
		author.setLastName(authorDTO.getLastName());
		// u.setDeleted(false);
		author.setRole(authorDTO.getRole());
		author.setAddress(authorDTO.getAddress());
		author.setCity(authorDTO.getCity());
		author.setState(authorDTO.getState());
		author.setUniversity(authorDTO.getUniversity());
		author.setZipCode(authorDTO.getZipCode());

		// Define a URI value for a document.
		String docId = "/users/" + author.getUsername() + ".xml";
				
		//ovo ne treba za kreiranje dokumenata, nije neophodno
		String xmlSource = jaxbObjectToXML(author);
		java.io.FileWriter fw = new java.io.FileWriter("data/"
				+ author.getUsername() + ".xml");
		fw.write(xmlSource);
		fw.close();
		//*********************************************
		// Create an input stream handle to hold XML content.
		InputStreamHandle handle = new InputStreamHandle(new FileInputStream(
				"data/" + author.getUsername() + ".xml"));
		
		xmlDocumentManager.write(docId, metadata, handle);

	}

	public Map<String, Object> login(LoginDTO loginDTO) {
		Map<String, Object> jsonRes = null;
		System.out.println("login funkcija servisa");
		try {
			jsonRes = new HashMap<>();
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());

			Authentication authentication = authenticationManager
					.authenticate(token);

			SecurityContextHolder.getContext()
					.setAuthentication(authentication);

			// UserDetails details =
			// userDetailsService.loadUserByUsername(loginDTO.getUsername());
			UserDetails details = (UserDetails) authentication.getPrincipal();

			jsonRes.put("cookie", tokenUtils.generateToken(details));

			return jsonRes;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// @SuppressWarnings("deprecation")
	public List<Author> getByRole(
			String role) throws ParserConfigurationException, IOException, JAXBException {

		System.out.println("GET AUTHORS BY ROLE: " + role);
		/*
		 * StructuredQueryBuilder qb = new StructuredQueryBuilder(); // Query
		 * definition is used to specify Google-style query string
		 * StringQueryDefinition queryDefinition =
		 * queryManager.newStringDefinition(); 
		 * StructuredQueryDefinition query =
		 * qb.containerQuery(qb.element("role"),
		 * qb.and(qb.value(qb.element("role"), role)));
		 */

		// Query definition is used to specify Google-style query string
		StringQueryDefinition queryDefinition = queryManager
				.newStringDefinition();

		// Set the criteria
		// String criteria = "";
		queryDefinition.setCriteria(role);
		//queryDefinition.setCollections(COLLECTION_REF);

		// Narrow a search to a specific collection
		//queryDefinition.setDirectory("/users");
		DocumentMetadataHandle metadata= new DocumentMetadataHandle();
		//StringHandle resultsHandle = new StringHandle();
		SearchHandle result= new SearchHandle();
		result= queryManager.search(queryDefinition, result);
		List<Author> authors= new ArrayList<Author>();
		for (MatchDocumentSummary summary : result.getMatchResults()) {
			JAXBContext context = JAXBContext.newInstance(Author.class);
			JAXBHandle<Author> handle = new JAXBHandle<Author>(context);
			System.out.println(summary.getUri());
			xmlDocumentManager.read(summary.getUri(), metadata, handle);
			System.out.println(metadata);
			authors.add(handle.get());
		}
		return authors;
	}
	
//	private List<Author> toSearchResult(SearchHandle resultsHandle) {
//        List<Author> authors = new ArrayList<>();
//        for (MatchDocumentSummary summary : resultsHandle.getMatchResults()) {
//            // Assumption: summary URI refers to JSON document
//            Ja jacksonHandle = new JacksonHandle();
//            jsonDocumentManager.read(summary.getUri(), jacksonHandle);
//            products.add(fetchProduct(jacksonHandle));
//        }
//        return new ProductSearchResult(products, resultsHandle.getFacetResult("price"),
//                resultsHandle.getFacetResult("year"));
//    }

	// @SuppressWarnings("deprecation")
	public Author getUserDetails(String uname) throws ParserConfigurationException, IOException, JAXBException {
		//Author author = xmlTojaxbObject(uname);
		//author.setPassword(null);
		JAXBContext context= JAXBContext.newInstance(Author.class);
		JAXBHandle<Author> handle= new JAXBHandle<Author>(context);
		
		DocumentMetadataHandle metadata= new DocumentMetadataHandle();
		String docId= "/users/" + uname + ".xml";
		xmlDocumentManager.read(docId, metadata, handle);
		Author author= handle.get();
		return author;
	}
	
	public Author getloggedInAuthor() throws ParserConfigurationException, IOException, JAXBException {
		//Author author = xmlTojaxbObject(uname);
		//author.setPassword(null);
		JAXBContext context= JAXBContext.newInstance(Author.class);
		JAXBHandle<Author> handle= new JAXBHandle<Author>(context);
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();
		
		DocumentMetadataHandle metadata= new DocumentMetadataHandle();
		String docId= "/users/" + uname + ".xml";
		xmlDocumentManager.read(docId, metadata, handle);
		Author author= handle.get();
		return author;
	}
}
