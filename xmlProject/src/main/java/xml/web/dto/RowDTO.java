package xml.web.dto;

import java.util.ArrayList;
import java.util.List;

import xml.model.Table;
import xml.model.Table.Row;
import xml.model.Table.Row.Columns;

public class RowDTO {
	 private List<ColumnDTO> columns;

	public List<ColumnDTO> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnDTO> columns) {
		this.columns = columns;
	}

	public RowDTO(Row r) {
		super();
		
		List<ColumnDTO> cols = new ArrayList<>();
		for (Columns column : r.getColumns()) {
			cols.add(new ColumnDTO(column));
		}
		
		this.columns = cols;
	}
	 
	public RowDTO() {
		super();		
	}
	
	public Row ToRowClass() {
		Row r = new Row();
		
		List<Columns> colls = new ArrayList<Table.Row.Columns>();
		for (ColumnDTO columnDTO : columns) {
			colls.add(columnDTO.ToColumnClass());
		}
		r.setColumns(colls);
		
		return r;
	}
}
