package xml;

import xml.Util;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.query.QueryManager;


@SpringBootApplication()//exclude = {SecurityAutoConfiguration.class })
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @SuppressWarnings("deprecation")
    @Bean
    public DatabaseClient dbClient() throws IOException {
    	xml.Util.ConnectionProperties props= Util.loadProperties();
    	// Initialize the database client
		if (props.database.equals("")) {
			System.out.println("[INFO] Using default database.");
			return DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password,
					props.authType);
		} else {
			System.out.println("[INFO] Using \"" + props.database + "\" database.");
			return DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password,
					props.authType);
		}
    }
    
    @Bean
	public QueryManager getQueryManager() throws IOException {
		return dbClient().newQueryManager();
	}

	@Bean
	public XMLDocumentManager getXMLDocumentManager() throws IOException {
		return dbClient().newXMLDocumentManager();
	}

	@Bean
	public JSONDocumentManager getJSONDocumentManager() throws IOException {
		return dbClient().newJSONDocumentManager();
	}
	
	@Bean
	public String getMarkLogicBaseURL() throws IOException {
		xml.Util.ConnectionProperties props= Util.loadProperties();
		return String.format("http://%s:%d", props.host, props.port);
	}

}
