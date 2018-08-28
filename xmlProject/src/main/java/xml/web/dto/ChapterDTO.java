package xml.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import xml.model.Chapter;
import xml.model.Figure;
import xml.model.Table;

public class ChapterDTO {
	
	private String title;
    
    private java.util.List<ChapterDTO> chapter;
    
    private xml.model.List list;
    
    private TableDTO table;
    
    private FigureDTO figure;
    
    private java.util.List<String> paragraph;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.util.List<ChapterDTO> getChapter() {
		return chapter;
	}

	public void setChapter(java.util.List<ChapterDTO> chapter) {
		this.chapter = chapter;
	}

	public xml.model.List getList() {
		return list;
	}

	public void setList(xml.model.List list) {
		this.list = list;
	}

	public TableDTO getTable() {
		return table;
	}

	public void setTable(TableDTO table) {
		this.table = table;
	}

	public FigureDTO getFigure() {
		return figure;
	}

	public void setFigure(FigureDTO figure) {
		this.figure = figure;
	}

	public java.util.List<String> getParagraph() {
		return paragraph;
	}

	public void setParagraph(java.util.List<String> paragraph) {
		this.paragraph = paragraph;
	}

	public ChapterDTO(Chapter c) {
		super();
		this.title = c.getTitle();		
		this.chapter = new ArrayList<ChapterDTO>();
		for (Chapter chapter : c.getChapter()) {
			this.chapter.add(new ChapterDTO(chapter));
		}
				
		this.list = c.getList();
		this.table = new TableDTO(c.getTable().getRow());
		this.figure = new FigureDTO(c.getFigure());
		this.paragraph = c.getParagraph();
	}
	
	public Chapter ToChapterClass(){
		
		Chapter c = new Chapter();
		
		c.setTitle(title);		
		List<Chapter> chapters = new ArrayList<Chapter>();
		if(this.chapter != null){
			for (ChapterDTO chapterDto : this.chapter) {
				chapters.add(chapterDto.ToChapterClass());
			}
		}
		c.setChapter(chapters);
		c.setList(this.list);
		c.setTable(table.ToTableClass());
		c.setFigure(this.figure.ToFigureClass());
		c.setParagraph(this.paragraph);
	
		return c;
	}
	
	public ChapterDTO() {
		super();
	}
    
    
    
    
    
}
