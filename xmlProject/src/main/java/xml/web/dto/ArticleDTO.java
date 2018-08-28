package xml.web.dto;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import xml.model.Author;
import xml.model.Chapter;
import xml.model.Reference;

public class ArticleDTO {
    private String title;
    private AbstractDTO _abstract;
    private String paperType;
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public AbstractDTO get_abstract() {
		return _abstract;
	}
	public void set_abstract(AbstractDTO _abstract) {
		this._abstract = _abstract;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public List<AuthorDTO> getAuthor() {
		return author;
	}
	public void setAuthor(List<AuthorDTO> author) {
		this.author = author;
	}
	public List<ReferenceDTO> getReference() {
		return reference;
	}
	public void setReference(List<ReferenceDTO> reference) {
		this.reference = reference;
	}
	public List<ChapterDTO> getChapter() {
		return chapter;
	}
	public void setChapter(List<ChapterDTO> chapter) {
		this.chapter = chapter;
	}
	public List<String> getKeyword() {
		return keyword;
	}
	public void setKeyword(List<String> keyword) {
		this.keyword = keyword;
	}
	public CoverLetterDTO getCoverLetterDTO() {
		return coverLetter;
	}
	public void setCoverLetterDTO(CoverLetterDTO coverLetter) {
		this.coverLetter = coverLetter;
	}
	public Integer getVol() {
		return vol;
	}
	public void setVol(Integer vol) {
		this.vol = vol;
	}
	public Integer getIssue() {
		return issue;
	}
	public void setIssue(Integer issue) {
		this.issue = issue;
	}
	public String getPp() {
		return pp;
	}
	public void setPp(String pp) {
		this.pp = pp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public XMLGregorianCalendar getReceived() {
		return received;
	}
	public void setReceived(XMLGregorianCalendar received) {
		this.received = received;
	}
	public XMLGregorianCalendar getAccepted() {
		return accepted;
	}
	public void setAccepted(XMLGregorianCalendar accepted) {
		this.accepted = accepted;
	}
	public XMLGregorianCalendar getRevised() {
		return revised;
	}
	public void setRevised(XMLGregorianCalendar revised) {
		this.revised = revised;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getJournalID() {
		return journalID;
	}
	public void setJournalID(String journalID) {
		this.journalID = journalID;
	}
	private List<AuthorDTO> author;
    private List<ReferenceDTO> reference;
    private List<ChapterDTO> chapter;
    private List<String> keyword;
    private CoverLetterDTO coverLetter;
    private Integer vol;
    private Integer issue;
    private String pp;
    private String status;
    private String version;
    private XMLGregorianCalendar received;
    private XMLGregorianCalendar accepted;
    private XMLGregorianCalendar revised;
    private String id;
    private String category;
    private String journalID;
}
