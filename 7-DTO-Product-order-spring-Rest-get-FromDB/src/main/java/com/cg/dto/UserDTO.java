package com.cg.dto;

import com.cg.entity.User;

public class UserDTO {
	private int id;
	private String username;
	private String password;
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	public static UserDTO fromEntity(User user)
	{
		return new UserDTO(user.getId(),user.getUsername(),user.getPassword());
	}
	public User toEntity()
	{
		return new User(this.id,this.username,this.password);
	}
}
