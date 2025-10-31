package com.loginpagewithsecurity.service;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loginpagewithsecurity.dao.UserRepository;
import com.loginpagewithsecurity.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	
	
	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
		User user=userRepository.findByUsername(username);
		
		if(Objects.isNull(user)) {
			System.out.println("User Not Found!!!");
			throw new UsernameNotFoundException("username is not available");
		}
		
		return new CustomUserDetails(user);
	}

}
