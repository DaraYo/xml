package xml.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.DocumentPatchBuilder;
import com.marklogic.client.document.DocumentPatchBuilder.Position;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.io.JAXBHandle;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.io.marker.DocumentPatchHandle;
import com.marklogic.client.query.QueryDefinition;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StructuredQueryBuilder;
import com.marklogic.client.util.EditableNamespaceContext;

import xml.model.Abstract;
import xml.model.Article;
import xml.model.Author;
import xml.model.Chapter;
import xml.model.CoverLetter;
import xml.model.Reference;
import xml.web.dto.AbstractDTO;
import xml.web.dto.ArticleDTO;
import xml.web.dto.AuthorDTO;
import xml.web.dto.ChapterDTO;
import xml.web.dto.CoverLetterDTO;
import xml.web.dto.ReferenceDTO;

@Service
public class ArticleService {
	
	@Autowired
	private DatabaseClient client;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private XMLDocumentManager xmlDocumentManager;
	
	public static final String COLLECTION_REF = "/articles/";
	
	//@Autowired
	//protected ArticleRepository nrRepositoryXML;
	
	@Autowired
	private QueryManager queryManager;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	private static String jaxbObjectToXML(Article article) {
		String xmlString = "";
		try {
			JAXBContext context = JAXBContext.newInstance(Article.class);
			Marshaller m = context.createMarshaller();
			m.setProperty("com.sun.xml.bind.namespacePrefixMapper",
					new NSPrefixMapper("http://www.uns.ac.rs/naucniRad", "nr"));
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

			StringWriter sw = new StringWriter();
			m.marshal(article, sw);
			xmlString = sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return xmlString;
	}

	private Article xmlTojaxbObject(String id) {

		XMLDocumentManager xmlManager = client.newXMLDocumentManager();
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();

		String docId = "/articles/" + id + ".xml";

		Article a = new Article();
		try {
			JAXBContext context = JAXBContext.newInstance(Article.class);
			JAXBHandle<Article> handle = new JAXBHandle<Article>(context);
			xmlManager.read(docId, metadata, handle);

			a = handle.get();
			// Unmarshaller unmarshaller = context.createUnmarshaller();

			// Unmarshalling generi�e objektni model na osnovu XML fajla
			// u = (User) unmarshaller.unmarshal(resultsDocument);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		//client.release();

		return a;

	}

	public void add(String document) throws IOException, ParserConfigurationException, JAXBException, DatatypeConfigurationException
	{
		//ArticleDTO articleDTO
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();
		metadata.getCollections().add(COLLECTION_REF);
		//u kontroleru poslati article, pretvoriti dto objekat u article objekat
				
		// Create a document manager to work with XML files.		
//		Article article = new Article();
//		
//		AbstractDTO abstractDTO = articleDTO.get_abstract();
//		if(abstractDTO != null){
//			Abstract abs = new Abstract();
//			abs.setDefaultAbstract(abstractDTO.getDefaultAbstract());
//			abs.setFreeAbstract(abstractDTO.getFreeAbstract());
//			article.setAbstract(abs);
//		}	
//		
//		//article.setAccepted(articleDTO.getAccepted());
//		article.setCategory(articleDTO.getCategory());		
//		
//		List<AuthorDTO> authorsDTO = articleDTO.getAuthor();
//		if(authorsDTO != null && authorsDTO.size() > 0){
//			List<Author> authors = new ArrayList();
//			for (AuthorDTO a : authorsDTO) {
//				authors.add(a.ToAuthorClass());
//			}
//			article.setAuthor(authors);
//		}
//		
//		CoverLetterDTO coverLetterDTO = articleDTO.getCoverLetterDTO();
//		if(coverLetterDTO != null){
//			CoverLetter coverLetter = new CoverLetter();
//			Author author = userService.getloggedInAuthor();			
//			coverLetter.setAuthor(author);
//			coverLetter.setClosing(coverLetterDTO.getClosing());
//			coverLetter.setDate(coverLetterDTO.getDate());
//			
//			AuthorDTO editor = coverLetterDTO.getEditorDTO();		
//			coverLetter.setEditor(editor.ToAuthorClass());
//			coverLetter.setSalutation(coverLetterDTO.getSalutation());
//			coverLetter.setSignature(coverLetterDTO.getSalutation());		
//			article.setCoverLetter(coverLetter);
//		}		
//		
//		article.setId(UUID.randomUUID().toString());
//		article.setIssue(1);
//		article.setJournalID(articleDTO.getJournalID());
//		article.setPaperType(articleDTO.getPaperType());
//		article.setPp(articleDTO.getPp());
//		
//		GregorianCalendar c = new GregorianCalendar();
//		Date date = new Date();
//		c.setTime(date);
//		XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//		article.setReceived(xmlDate);
//		//article.setRevised();
//		article.setStatus("Pending");//Pending, accepted, declined, deleted
//		article.setTitle(articleDTO.getTitle());
//		article.setVersion("1.0.0");
//		article.setVol(1);
//		
//		List<ReferenceDTO> referencesDTO = articleDTO.getReference();
//		if(referencesDTO != null && referencesDTO.size() > 0){
//			List<Reference> references = new ArrayList();
//			for (ReferenceDTO r : referencesDTO) {
//				references.add(r.ToReferenceClass());
//			}
//			
//			article.setReference(references);
//		}
//		
//		List<ChapterDTO> chaptersDTO = articleDTO.getChapter();
//		if(chaptersDTO != null && chaptersDTO.size() > 0){
//			List<Chapter> chapters = new ArrayList();
//			for (ChapterDTO ch : chaptersDTO) {
//				chapters.add(ch.ToChapterClass());
//			}
//			
//			article.setChapter(chapters);
//		}
//				
//		article.setKeyword(articleDTO.getKeyword());		
		String id= UUID.randomUUID().toString();
		// Define a URI value for a document.
		//String docId = "/articles/" + article.getId() + ".xml";
		String docId = "/articles/" + id + ".xml";
		//ovo ne treba za kreiranje dokumenata, nije neophodno
		//String xmlSource = jaxbObjectToXML(article);
		java.io.FileWriter fw = new java.io.FileWriter("data/"
				+ id + ".xml");
		fw.write(document);
		fw.close();
		//*********************************************
		// Create an input stream handle to hold XML content.
		InputStreamHandle handle = new InputStreamHandle(new FileInputStream(
				"data/" + id + ".xml"));
		
		xmlDocumentManager.write(docId, metadata, handle);
	}
	
	public void delete(String id) {
		//odraditi logicko brisanje, ne treba ovako, da bude implementirano fizicko
		/*if (xmlDocumentManager.exists(id) != null) {
			xmlDocumentManager.delete("/articles/"+id+".xml");
		}*/
		
		// Define a URI value for a document.
		String docId = "/articles/"+ id + ".xml";

		XMLDocumentManager xmlManager = client.newXMLDocumentManager();
		
		// Defining namespace mappings
		EditableNamespaceContext namespaces = new EditableNamespaceContext();
		namespaces.put("nr", "http://www.ftn.uns.ac.rs/naucniRad");
		//namespaces.put("fn", "http://www.w3.org/2005/xpath-functions");
		
		// Assigning namespaces to patch builder
		DocumentPatchBuilder patchBuilder = xmlManager.newPatchBuilder();
		patchBuilder.setNamespaces(namespaces);

		// Creating an XML patch
		/*
				<b:book category="TEST">
					<b:title lang=\"en\">Test book</b:title>
					<b:author>Test Author</b:author>
					<b:year>2016</b:year>
					<b:price>59.99</b:price>
				</b:book>
		 */
		/*String patch = "\t<b:book category=\"TEST\">\n" +
				"\t\t<b:title lang=\"en\">Test book</b:title>\n" +
				"\t\t<b:author>Test Author</b:author>\n" +
				"\t\t<b:year>2016</b:year>\n" +
				"\t\t<b:price>59.99</b:price>\n" +
				"\t</b:book>\n";
		
		// Defining XPath context
		String contextXPath1 = "/b:bookstore/b:book[1]";
		String contextXPath2 = "/b:bookstore";
		

		// Insert fragments
		patchBuilder.insertFragment(contextXPath1, Position.BEFORE, patch);
		patchBuilder.insertFragment(contextXPath1, Position.AFTER, patch);
		patchBuilder.insertFragment(contextXPath2, Position.LAST_CHILD, patch);
		
		DocumentPatchHandle patchHandle = patchBuilder.build();
		
		System.out.println("[INFO] Inserting nodes to \"" + docId + "\".");
		xmlManager.patch(docId, patchHandle);*/
		
		// Another patch
		patchBuilder = xmlManager.newPatchBuilder();
		patchBuilder.setNamespaces(namespaces);
		
		/*
		<b:book category=\"WEB\">
			<b:title lang=\"en\">AngularJS in Action</b:title>
			<b:author>Brian Ford</b:author>
			<b:author>Lukas Ruebbelke</b:author>
			<b:year>2014</b:year>
			<b:price>39.60</b:price>
		</b:book>
		 */
		
		Article a = xmlTojaxbObject(id);
		a.setStatus("deleted");
		
		String patch2 = jaxbObjectToXML(a);
		String patch = patch2.substring(patch2.indexOf("<article"));
		/*
		String patch2 = "\t<b:book category=\"WEB\">\n" +
				"\t\t<b:title lang=\"en\">AngularJS in Action</b:title>\n" +
				"\t\t<b:author>Brian Ford</b:author>\n" +
				"\t\t<b:author>Lukas Ruebbelke</b:author>\n" +
				"\t\t<b:year>2014</b:year>\n" +
				"\t\t<b:price>39.60</b:price>\n" +
				"\t</b:book>\n";*/
		
		
		String contextXPath = "article";
		// Replace fragment
		patchBuilder.replaceFragment(contextXPath, patch2);
		
		// Remove fragment
		//patchBuilder.delete(contextXPath1);
		DocumentPatchHandle patchHandle = patchBuilder.build();

		patchHandle = patchBuilder.build();
		
		System.out.println("[INFO] Replacing nodes in \"" + docId + "\".");
		xmlManager.patch(docId, patchHandle);
			
	}
	/*
	 *  public void updateAkt(Akt akt) throws JAXBException {

        DatabaseClient client = Connection.getConnection();

        // Create a document manager to work with XML files.
        XMLDocumentManager xmlManager = client.newXMLDocumentManager();

        // Define a URI value for a document.
        String docId = "/akt/" + akt.getId() + ".xml";

        // Defining namespace mappings
        EditableNamespaceContext namespaces = new EditableNamespaceContext();
        namespaces.put("a", "http://www.skustinans.rs/akti");
      //  namespaces.put("fn", "http://www.w3.org/2005/xpath-functions");

        // Assigning namespaces to patch builder
        DocumentPatchBuilder patchBuilder = xmlManager.newPatchBuilder();
        patchBuilder.setNamespaces(namespaces);

        String patch = "";

        //marshalling
        JAXBContext jaxbContext = null;
        try {

            jaxbContext = JAXBContext.newInstance(Akt.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(akt, sw);

            patch = sw.toString();
            System.out.println("patch " + patch);

            patch = patch.substring(patch.indexOf("<akt"));

            try {
                sw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Defining XPath context
        String contextXPath = "/a:akt";
        DocumentPatchHandle patchHandle;

        // insert fragment
        patchBuilder.replaceFragment(contextXPath, patch);

        patchHandle = patchBuilder.build();

        xmlManager.patch(docId, patchHandle);

        client.release();

    }
	 * */
	
	public List<Article> getAccepted() {
		return new ArrayList<Article>();
	}
	
	public List<Article> getInProgress() {
		return new ArrayList<Article>();
	}
	
	public List<Article> getDeclined() {
		return new ArrayList<Article>();
	}
	
	
	
	
	
	
	
	
	
}
