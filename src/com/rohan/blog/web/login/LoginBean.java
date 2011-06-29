package com.rohan.blog.web.login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.rohan.blog.common.encryptor.Encryptor;
import com.rohan.blog.delegate.LoginDelegate;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	

	@ManagedProperty(name="loginDelegate",value = "#{loginDelegate}")
	private LoginDelegate loginDelegate;
	
	
	public String login() {
		
		
		boolean success = loginDelegate.login(login, Encryptor.encrypt(password));
		
		if (success){
			return "index.xhtml";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong login or password"));			
			return "login.xhtml";
		}
		
	}
	
	public String logout(){
		loginDelegate.logout();
		return "/index.xhtml?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoginDelegate(LoginDelegate loginDelegate) {
		this.loginDelegate = loginDelegate;
	}

	
	
	
	
	
}
