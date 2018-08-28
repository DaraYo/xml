package xml.web.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xml.Util;
import xml.model.Article;
import xml.service.ArticleService;
import xml.service.UserService;
import xml.web.dto.ArticleDTO;
import xml.web.dto.UserDTO;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/articles")
public class ArticleController {
	
	@Autowired
	private UserService userService;
	
	@Autowired ArticleService articleService;
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addArticle(@RequestBody String document) throws IOException, ParserConfigurationException, JAXBException, DatatypeConfigurationException {
		//ArticleDTO articleDTO
		Article a= new Article();
		//a.setTitle(articleDTO.getTitle());
		//nastaviti dalje, sva polja namapirati na article
		articleService.add(document);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteArticle(@PathVariable String id) {
			articleService.delete(
					id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<ArticleDTO>> getAcceptedArticles() {
//			articleService.getAccepted(
//					articleDTO);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<ArticleDTO>> getAll() {
//			articleService.(
//					articleDTO);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<ArticleDTO>> getInProcedureArticles() {
//		try {
//			articleService.getInProcedure(
//					articleDTO);
//		return new ResponseEntity<List>(HttpStatus.OK);
//	}
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<ArticleDTO>> getDeclineArticles() {
//			articleService.getDeclined(
//					articleDTO);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	

}
