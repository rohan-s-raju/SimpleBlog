package com.rohan.blog.authentication.businessservice;

import org.springframework.security.access.annotation.Secured;

public interface AuthenticationModelBS {
	
	boolean login(String username, String password);

	@Secured({"ROLE_ADMIN","ROLE_REGISTERED"})
	void logout();
}
