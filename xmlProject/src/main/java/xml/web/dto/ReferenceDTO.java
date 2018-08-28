package xml.web.dto;

import javax.xml.bind.annotation.XmlElement;

import xml.model.Reference;

public class ReferenceDTO {

	private String title;
    
	private String author;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public ReferenceDTO(Reference r) {
		super();
		this.title = r.getTitle();
		this.author = r.getAuthor();
	}

	public ReferenceDTO() {
		super();
	}
	
	
	
	public Reference ToReferenceClass() {
		Reference r = new Reference();
		r.setTitle(this.title);
		r.setAuthor(this.author);
		
		return r;
	}
	
}
