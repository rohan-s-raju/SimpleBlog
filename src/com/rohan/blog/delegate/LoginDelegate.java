package com.rohan.blog.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rohan.blog.authentication.businessservice.AuthenticationModelBS;



@Component("loginDelegate")
public class LoginDelegate {
	
	@Autowired
	private AuthenticationModelBS authenticationModelBS;
	
	public boolean login(String username, String password){
		return authenticationModelBS.login(username, password);
	}

	
	public void logout(){
		authenticationModelBS.logout();
	}
}
