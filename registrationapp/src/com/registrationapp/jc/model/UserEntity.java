package com.registrationapp.jc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "user_table") 
public class UserEntity {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name="email")
	private String email;

	@Column(name="password")
	private String pass;
	
	public UserEntity() {
	}
	
	public UserEntity(int id, String email, String pass) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
