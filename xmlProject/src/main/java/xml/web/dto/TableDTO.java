package xml.web.dto;

import java.util.ArrayList;
import java.util.List;

import xml.model.Table;
import xml.model.Table.Row;
import xml.model.Table.Row.Columns;

public class TableDTO {
	private List<RowDTO> row;

	public List<RowDTO> getRow() {
		return row;
	}

	public void setRow(List<RowDTO> row) {
		this.row = row;
	}

	public TableDTO(List<Row> rows) {
		super();
		List<RowDTO> rowsDTO = new ArrayList<>();
		for (Row r : rows) {
			rowsDTO.add(new RowDTO(r));
		}
		
		this.row = rowsDTO;
	}

	public TableDTO() {
		super();
	}
	
	public Table ToTableClass(){
		Table t = new Table();
		
		List<Row> rows = new ArrayList<Table.Row>();
		
		for (RowDTO rowDTO : row) {
			rows.add(rowDTO.ToRowClass());
		}
		t.setRow(rows);
		
		return t;
	}
	
	
}
