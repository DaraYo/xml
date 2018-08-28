package xml.web.dto;

import xml.model.Figure;

public class FigureDTO {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FigureDTO(Figure f) {
		super();
		this.name = f.getName();
	}
	
	public FigureDTO() {
		super();		
	}
	
	public Figure ToFigureClass(){
		Figure f = new Figure();
		
		f.setName(this.name);
		
		return f;
	}
	
	
	
}
