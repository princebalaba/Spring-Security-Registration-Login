package com.princeCODEZ.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.princeCODEZ.entity.User;
import com.princeCODEZ.webDto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save (UserRegistrationDto registrationDto);

}
