package com.niit.musicmainee.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class UserDetails {
  @Id
  private String user_id;
  private String user_name;
  private String user_address;
  private String user_phoneno;
  private String user_dob;
  private String email_id;
  private String role_name="ROLE_USER";
  private String password;
  private String gender;
  
public UserDetails() 
{
	this.user_id = "user"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_address() {
	return user_address;
}
public void setUser_address(String user_address) {
	this.user_address = user_address;
}
public String getUser_phoneno() {
	return user_phoneno;
}
public void setUser_phoneno(String user_phoneno) {
	this.user_phoneno = user_phoneno;
}
public String getUser_dob() {
	return user_dob;
}
public void setUser_dob(String user_dob) {
	this.user_dob = user_dob;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}


public String getRole_name() {
	return role_name;
}
public void setRole_name(String role_name) {
	this.role_name = role_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
  
	
}
