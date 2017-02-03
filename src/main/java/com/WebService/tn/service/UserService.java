package com.WebService.tn.service;
import org.springframework.security.core.userdetails.UserDetails;

import com.WebService.tn.dto.UserRegistrationForm;
import com.WebService.tn.exception.UserAlreadyExistAuthenticationException;
public interface UserService {

	public UserDetails registerNewUser(UserRegistrationForm UserRegistrationForm)throws UserAlreadyExistAuthenticationException;

}
