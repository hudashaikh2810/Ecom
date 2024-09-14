package com.quitq.ECom.model;

import com.quitq.ECom.enums.RoleType;

import jakarta.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password; 
	
	@Enumerated(EnumType.STRING)
	private RoleType role;

	public User(int id, String username, String password, RoleType role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
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

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}
}
