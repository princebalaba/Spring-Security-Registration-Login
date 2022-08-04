package com.princeCODEZ.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.princeCODEZ.entity.Role;
import com.princeCODEZ.entity.User;
import com.princeCODEZ.repo.UserRepo;
import com.princeCODEZ.webDto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private BCryptPasswordEncoder cryptPasswordEncoder;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
							registrationDto.getLastName(),
							registrationDto.getEmail(), 							 
							cryptPasswordEncoder.encode(registrationDto.getPassword()),
							Arrays.asList(new Role("ROLE_USER")));
		return userRepo.save(user);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or Password");
		}
		return new org.springframework.security.core.userdetails.
				User(user.getEmail(),
						user.getPassword(),
						rolesAuthorities(user.getRoles()));
	}
	
	//Roles Method
	private Collection<? extends GrantedAuthority> rolesAuthorities(Collection <Role> roles){ 
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		
		
		
	}
	

}
