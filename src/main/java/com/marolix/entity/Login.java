package com.marolix.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login_Table")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "UserId" , nullable = false)
	private String userId;
	@Column(name = "password")
	private String passWord;
	
	@OneToOne(targetEntity = RegistrationPage.class,cascade = CascadeType.ALL)
	private RegistrationPage register;
	
	public Login() {
		
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public RegistrationPage getRegister() {
		return register;
	}
	public void setRegister(RegistrationPage register) {
		this.register = register;
	}
	public Login(int id, String userId, String passWord, RegistrationPage register) {
		super();
		this.id = id;
		this.userId = userId;
		this.passWord = passWord;
		this.register = register;
	}
	
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", userId=" + userId + ", passWord=" + passWord + ", register=" + register + "]";
	}
	
	
}
