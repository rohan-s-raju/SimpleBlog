package com.rohan.blog.authentication.businessservice;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.NoResultException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rohan.blog.authentication.dataaccess.PersonModelDao;
import com.rohan.blog.entity.Person;

/*
 * Spring-security requires an implementation of UserDetailService. 
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Resource(name="personModelDao")
	private PersonModelDao personModelDao;

	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException{
		
		try {
			
			Person p = personModelDao.getPersonByLogin(username);					
			
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new GrantedAuthorityImpl(p.getRole().getName())); // RoleName = "ROLE_ADMIN" or "ROLE_USER"
			
			
			org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(p.getUsername(), p.getPassword(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked, grantedAuthorities);
			
			return user;
			
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("No such user");
		}
			
	}

}
