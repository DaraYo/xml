package xml.web.dto;

import xml.model.Abstract;
import xml.model.DefaultAbstract;

public class AbstractDTO {
	
	 private DefaultAbstract defaultAbstract;
	 private String freeAbstract;
	 
	public DefaultAbstract getDefaultAbstract() {
		return defaultAbstract;
	}
	public void setDefaultAbstract(DefaultAbstract defaultAbstract) {
		this.defaultAbstract = defaultAbstract;
	}
	public String getFreeAbstract() {
		return freeAbstract;
	}
	public void setFreeAbstract(String freeAbstract) {
		this.freeAbstract = freeAbstract;
	}
	
	public AbstractDTO(Abstract a) {
		super();
		this.defaultAbstract = a.getDefaultAbstract();
		this.freeAbstract = a.getFreeAbstract();
	}
	
	public AbstractDTO() {
		
	}
	 
	 
}
