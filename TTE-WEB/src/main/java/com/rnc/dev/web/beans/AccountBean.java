package com.rnc.dev.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.rnc.dev.web.entities.Account;
import com.rnc.dev.web.enums.AccountRole;
import com.rnc.dev.web.enums.AccountStatus;
import com.rnc.dev.web.services.AccountService;

@Named
@ViewScoped
public class AccountBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
private Account account;
	
	@Inject
	private AccountService accountservice;
	
	
	private AccountRole [] accountroles;
	
	private AccountStatus [] accountstatus;
	
	private String Name;
	private String Password;
	private String Email;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@PostConstruct
	public void intialize() {
		
		account = new Account();
		accountroles = AccountRole.values();
		accountstatus = AccountStatus.values();  
	}
	
	public void save() {
		
		accountservice.save(account);
		intialize();
		login();
	}

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

		public void login() {
		
		if( Name=="admin" ||Password=="admin123" ||Email=="admin@gmail.com" ) {
			
			String message = "You're login with admin!";
			
			System.out.println(message);
		
			
		}
		else {
			
				String message = "You're login with user!";
			
			System.out.println(message);
		
		}
		
		
		
	}
	public AccountRole[] getAccountRole() {
		return accountroles;
	}

	public void setAccountRole(AccountRole[] accountroles) {
		this.accountroles = accountroles;
	}

	public AccountStatus [] getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(AccountStatus [] accountstatus) {
		this.accountstatus = accountstatus;
	}
	
	

}
