package xml.web.dto;

import java.util.List;

import xml.model.Table.Row.Columns;

public class ColumnDTO {
	private List<String> cell;

	public List<String> getCell() {
		return cell;
	}

	public void setCell(List<String> cell) {
		this.cell = cell;
	}

	public ColumnDTO(Columns c) {
		super();
		this.cell = c.getCell();
	}
	
	public ColumnDTO() {
		super();		
	}
	
	public Columns ToColumnClass() {
		Columns coll = new Columns();
		coll.setCell(this.cell);
		
		return coll;
	}
}
