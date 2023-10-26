package com.marolix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Creditials")
public class Creditials {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)

	 private Long id;
	 private String username;
	 private String passCode;
	 
	 
	public Creditials() {
		super();
	}
	public Creditials(Long id, String username, String passCode) {
		super();
		this.id = id;
		this.username = username;
		this.passCode = passCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassCode() {
		return passCode;
	}
	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}
	@Override
	public String toString() {
		return "Creditials [id=" + id + ", username=" + username + ", passCode=" + passCode + "]";
	}
	
}
