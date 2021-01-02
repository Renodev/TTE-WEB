package com.rnc.dev.web.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.rnc.dev.web.enums.AccountRole;
import com.rnc.dev.web.enums.AccountStatus;

@Entity
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	
	@Enumerated(EnumType.STRING)
	private AccountRole accountRole;
	
	@Lob
	private String address;

	private boolean erase;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public AccountRole getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(AccountRole accountRole) {
		this.accountRole = accountRole;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isErase() {
		return erase;
	}

	public void setErase(boolean erase) {
		this.erase = erase;
	}

}
