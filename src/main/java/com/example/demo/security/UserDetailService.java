package com.example.demo.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if( "root".equals(username)) {
			return new User("root", "root", new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Usuario no existe " + username);
		}
	}
	
}
