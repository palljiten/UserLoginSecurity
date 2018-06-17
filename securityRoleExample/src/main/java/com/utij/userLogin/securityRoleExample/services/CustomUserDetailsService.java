package com.utij.userLogin.securityRoleExample.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utij.userLogin.securityRoleExample.model.CustomUserDetails;
import com.utij.userLogin.securityRoleExample.model.Users;
import com.utij.userLogin.securityRoleExample.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Users> optionalUsers= userRepository.findbyName(userName);
		optionalUsers
				.orElseThrow(()->new UsernameNotFoundException("User Name is not found"));
			    
		return optionalUsers
				.map(CustomUserDetails::new).get();
				
		
		
	}

}
