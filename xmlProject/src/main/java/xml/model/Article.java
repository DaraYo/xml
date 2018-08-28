//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.26 at 05:59:36 PM CEST 
//


package xml.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

import xml.web.dto.CoverLetterDTO;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucniRad}title"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucniRad}abstract"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucniRad}paperType" minOccurs="0"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/user}author" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucniRad}reference" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucniRad}chapter" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucniRad}keyword" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/coverLetter}coverLetter"/>
 *       &lt;/sequence>
 *       &lt;attribute name="vol" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="issue" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="pp">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{1,}-\d{1,} "/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="received" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="accepted" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="revised" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="journalID" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "title",
    "_abstract",
    "paperType",
    "author",
    "reference",
    "chapter",
    "keyword",
    "coverLetter"
})
@XmlRootElement(name = "article")
public class Article {

    public void setAuthor(List<Author> author) {
		this.author = author;
	}

	@XmlElement(required = true)
    protected String title;
    @XmlElement(name = "abstract", required = true)
    protected Abstract _abstract;
    @XmlElement(nillable = true)
    protected String paperType;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/user", required = true)
    protected List<Author> author;
    @XmlElement(required = true)
    protected List<Reference> reference;
    @XmlElement(required = true, nillable = true)
    protected List<Chapter> chapter;
    protected List<String> keyword;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/coverLetter", required = true)
    protected CoverLetter coverLetter;
    @XmlAttribute(name = "vol")
    protected Integer vol;
    @XmlAttribute(name = "issue")
    protected Integer issue;
    @XmlAttribute(name = "pp")
    protected String pp;
    @XmlAttribute(name = "status")
    protected String status;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "received")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar received;
    @XmlAttribute(name = "accepted")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accepted;
    @XmlAttribute(name = "revised")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar revised;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "category")
    protected String category;
    @XmlAttribute(name = "journalID")
    protected String journalID;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link Abstract }
     *     
     */
    public Abstract getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Abstract }
     *     
     */
    public void setAbstract(Abstract value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the paperType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaperType() {
        return paperType;
    }

    /**
     * Sets the value of the paperType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaperType(String value) {
        this.paperType = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the author property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Author }
     * 
     * 
     */
    public List<Author> getAuthor() {
        if (author == null) {
            author = new ArrayList<Author>();
        }
        return this.author;
    }

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reference }
     * 
     * 
     */
    public List<Reference> getReference() {
        if (reference == null) {
            reference = new ArrayList<Reference>();
        }
        return this.reference;
    }

    /**
     * Gets the value of the chapter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chapter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChapter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Chapter }
     * 
     * 
     */
    public List<Chapter> getChapter() {
        if (chapter == null) {
            chapter = new ArrayList<Chapter>();
        }
        return this.chapter;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<String>();
        }
        return this.keyword;
    }

    /**
     * Gets the value of the coverLetter property.
     * 
     * @return
     *     possible object is
     *     {@link CoverLetterDTO }
     *     
     */
    public CoverLetter getCoverLetter() {
        return coverLetter;
    }

    /**
     * Sets the value of the coverLetter property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverLetterDTO }
     *     
     */
    public void setCoverLetter(CoverLetter value) {
        this.coverLetter = value;
    }

    /**
     * Gets the value of the vol property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVol() {
        return vol;
    }

    /**
     * Sets the value of the vol property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVol(Integer value) {
        this.vol = value;
    }

    /**
     * Gets the value of the issue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIssue() {
        return issue;
    }

    /**
     * Sets the value of the issue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIssue(Integer value) {
        this.issue = value;
    }

    /**
     * Gets the value of the pp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPp() {
        return pp;
    }

    /**
     * Sets the value of the pp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPp(String value) {
        this.pp = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the received property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReceived() {
        return received;
    }

    /**
     * Sets the value of the received property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReceived(XMLGregorianCalendar value) {
        this.received = value;
    }

    /**
     * Gets the value of the accepted property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccepted() {
        return accepted;
    }

    /**
     * Sets the value of the accepted property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccepted(XMLGregorianCalendar value) {
        this.accepted = value;
    }

    /**
     * Gets the value of the revised property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRevised() {
        return revised;
    }

    /**
     * Sets the value of the revised property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRevised(XMLGregorianCalendar value) {
        this.revised = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the journalID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public String getJournalID() {
        return journalID;
    }

    /**
     * Sets the value of the journalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setJournalID(String value) {
        this.journalID = value;
    }

	public void setReference(List<Reference> reference) {
		this.reference = reference;
	}

	public void setChapter(List<Chapter> chapter) {
		this.chapter = chapter;
	}

	public void setKeyword(List<String> keyword) {
		this.keyword = keyword;
	}

}