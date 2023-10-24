package com.marolix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Registeration_Table")
public class RegistrationPage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Registration_Id", nullable = false)
	private int registerationId;
	private String name;
	private String gender;
	private String phoneNumber;
	private String emailId;
	
	
	public int getRegisterationId() {
		return registerationId;
	}
	public void setRegisterationId(int registerationId) {
		this.registerationId = registerationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
