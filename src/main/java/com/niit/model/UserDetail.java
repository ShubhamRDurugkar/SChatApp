package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
@SequenceGenerator(name = "userdetailidseq", sequenceName = "USERDetail_ID_SEQ", allocationSize = 1)
public class UserDetail {

	
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userdetailidseq")
	@Column(name = "USER_ID")
	private int id;*/

	@Id
	@Column(name = "loginname")
	private String loginname;

	@Column(name = "password")
	private String password;

	@Column(name="USERNAME")
	private String username;
	
	@Column(name = "emailid")
	private String emailId;

	@Column(name = "mobileNo")
	String mobileNo;

	@Column(name = "address")
	String address;

	@Column(name = "role")
	private String role;

	@Column(name="isOnline")
	private String isOnline;
	
	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
