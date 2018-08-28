package xml.web.dto;

import xml.model.Author;


public class AuthorDTO {
    
    private String university;    
    private String city;    
    private String state;    
    private String zipCode;    
    private String address;    
    private String username;
	private String password;
	private String name;
	private String lastName;
	private String email;
	private String role;
	
	
	
	
	public AuthorDTO() {
		super();
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

	public AuthorDTO(Author author)
	{
		setAddress(author.getAddress());
		setCity(author.getCity());
		setEmail(author.getEMail());
		setLastName(author.getLastName());
		setName(author.getName());		
		setRole(author.getRole());
		setState(author.getState());
		setUniversity(author.getUniversity());
		setUsername(author.getUsername());
		setZipCode(author.getZipCode());
		
	}
	
	public Author ToAuthorClass(){
		Author a = new Author();
		a.setAddress(getAddress());
		a.setCity(getCity());
		a.setEMail(getEmail());
		a.setLastName(getLastName());
		a.setName(getName());		
		a.setRole(getRole());
		a.setState(getState());
		a.setUniversity(getUniversity());
		a.setUsername(getUsername());
		a.setZipCode(getZipCode());
		
		return a;
	}
	
}
