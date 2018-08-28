package xml.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.TransformerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.JAXBHandle;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;

import xml.Util;
import xml.model.Author;
import xml.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final String COLLECTION = "/users";
	
	@Autowired
	private DatabaseClient client;
	
	@Autowired
	private XMLDocumentManager xmlDocumentManager;
	
	@Autowired
	private UserService userService;
	
	//private static DatabaseClient client;
	
//	private User xmlTojaxbObject(String uname) {
// 		
// 		//XMLDocumentManager xmlManager = client.newXMLDocumentManager();
//		DocumentMetadataHandle metadata = new DocumentMetadataHandle();
//		String docId = "/users/"+uname+".xml";
//		User u= new User();
//	    try {
//	        JAXBContext context = JAXBContext.newInstance(User.class);
//	        JAXBHandle<User> handle = new JAXBHandle<User>(context);
//	        xmlDocumentManager.read(docId, metadata, handle);
//
//			u = handle.get();
//	        //Unmarshaller unmarshaller = context.createUnmarshaller();
//			
//			// Unmarshalling generi�e objektni model na osnovu XML fajla 
//			//u = (User) unmarshaller.unmarshal(resultsDocument);
//
//	    } catch (JAXBException e) {
//	        e.printStackTrace();
//	    }
//	    client.release();
//	    
//	    return u;

//	}
	
	@Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> grantedAuthorities;
		Author author = userService.xmlTojaxbObject(username);
	    if (author == null) {
	      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	    } else {
	    	//gu= new SimpleGrantedAuthority(user.getRole());
	    	grantedAuthorities = new ArrayList<GrantedAuthority>();
	    		grantedAuthorities.add(new SimpleGrantedAuthority(author.getRole()));
	    	}
	    	
	    	//Java 1.8 way   	
	    	/*List<GrantedAuthority> grantedAuthorities = user.getUserAuthorities().stream()
	                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority().getName()))
	                .collect(Collectors.toList());*/
	    	
	    	return new org.springframework.security.core.userdetails.User(
	    			author.getUsername(),
	    			author.getPassword(),
	    		  grantedAuthorities);
	    }
	  }
