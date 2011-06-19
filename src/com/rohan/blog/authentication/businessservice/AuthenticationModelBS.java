package com.rohan.blog.authentication.businessservice;

import javax.annotation.security.RolesAllowed;

public interface AuthenticationModelBS {
	
	boolean login(String username, String password);

	@RolesAllowed({"ROLE_ADMIN","ROLE_REGISTERED"})
	void logout();
}
