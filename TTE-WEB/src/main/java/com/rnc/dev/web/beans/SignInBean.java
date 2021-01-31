package com.rnc.dev.web.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.Account;
import com.rnc.dev.web.enums.AccountRole;
import com.rnc.dev.web.services.AccountService;

@Named
@ViewScoped
public class SignInBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;

	private String phone;
	
	private String password;
	
	@Inject
	private AccountService accountService;
	
	public String signIn () {
		Account account = accountService.findByPhoneAndPassword(phone, password);
		if (account == null) {
			message = "Phone And Password doesn't match!";
			return null;
		} else {
			if (account.getAccountRole().equals(AccountRole.Customer)) {
				return null;
			} else {
				return "adminDashboard.xhtml";
			}
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
