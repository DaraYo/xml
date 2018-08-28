package xml.web.dto;

import xml.model.User;

public class UserDTO{
	private String username;
	private String password;
	private String name;
	private String lastName;
	private String email;
	private String role;

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
	
	public UserDTO() {};
	
	public UserDTO(User user) {
		//this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.name = user.getName();
		this.lastName = user.getLastName();
		this.email = user.getEMail();
		this.role= user.getRole();
	}
}

