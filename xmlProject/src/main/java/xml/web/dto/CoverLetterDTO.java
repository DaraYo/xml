package xml.web.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

import xml.model.Author;
import xml.model.CoverLetter;

public class CoverLetterDTO {
	private String salutation;
    
    private List<String> paragraph;
    
    private String closing;
    
    private String signature;
    
    private AuthorDTO editor;
    
    private AuthorDTO author;
 
    private XMLGregorianCalendar date;
  
    private String id;

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public List<String> getParagraph() {
		return paragraph;
	}

	public void setParagraph(List<String> paragraph) {
		this.paragraph = paragraph;
	}

	public String getClosing() {
		return closing;
	}

	public void setClosing(String closing) {
		this.closing = closing;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public AuthorDTO getEditorDTO() {
		return editor;
	}

	public void setEditorDTO(AuthorDTO editor) {
		this.editor = editor;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public XMLGregorianCalendar getDate() {
		return date;
	}

	public void setDate(XMLGregorianCalendar date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CoverLetterDTO(CoverLetter c) {		
		this.salutation = c.getSalutation();
		this.paragraph = c.getParagraph();
		this.closing = c.getClosing();
		this.signature = c.getSignature();
		this.editor = new AuthorDTO(c.getEditor());
		this.author = new AuthorDTO(c.getAuthor());
		this.date = c.getDate();
		this.id = c.getId();
	}

	public CoverLetterDTO() {
		// TODO Auto-generated constructor stub
	}
    
    
}
