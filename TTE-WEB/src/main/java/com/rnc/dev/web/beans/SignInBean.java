package com.rnc.dev.web.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class SignInBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String phone;
	
	private String password;
	
	public void signIn () {
		System.out.println(phone);
		System.out.println(password);
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

}
