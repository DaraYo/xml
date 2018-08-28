package xml.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.query.QueryManager;

import xml.model.Article;

@Component
public class ArticleRepository {
	public static final String COLLECTION_REF = "/ftn/naucni_rad";
	public static final int PAGE_SIZE = 10;
	
	@Autowired
	protected QueryManager queryManager;
	@Autowired
	protected XMLDocumentManager xmlDocumentManager;
	
	public void addArticle(Article a) {
		
	}
	
	public void deleteArticle(String id) {
		
	}
	
	public void findById(String id) {
		
	}
	
	public List<Article> getPublishedArticles(){
		return new ArrayList<Article>();
	}
}
