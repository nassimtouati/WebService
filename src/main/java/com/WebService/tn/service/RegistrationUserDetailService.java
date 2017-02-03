package com.WebService.tn.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.WebService.tn.database.dao.UserDAO;
import com.WebService.tn.database.model.Role;
import com.WebService.tn.database.model.User;
import com.WebService.tn.dto.LocalUser;
import com.WebService.tn.dto.UserRegistrationForm;
import com.WebService.tn.exception.UserAlreadyExistAuthenticationException;
import com.WebService.tn.service.UserService;

@Service("registrationUserDetailService")
public class RegistrationUserDetailService implements UserService {

    @Autowired
    @Qualifier(value = "localUserDetailService")
    private UserDetailsService userDetailService;

    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional(value = "transactionManager")
    public LocalUser registerNewUser(final UserRegistrationForm userRegistrationForm) throws UserAlreadyExistAuthenticationException {

    	com.WebService.tn.database.model.User userExist = userDAO.get(userRegistrationForm.getUserId());
        if (userExist != null) {
            throw new UserAlreadyExistAuthenticationException("User with email id " + userRegistrationForm.getEmail() + " already exist");
        }

        com.WebService.tn.database.model.User user = buildUser(userRegistrationForm);
        userDAO.save(user);
        userDAO.flush();

        return (LocalUser) userDetailService.loadUserByUsername(userRegistrationForm.getUserId());
    }

    private User buildUser(final UserRegistrationForm formDTO) {
        User user = new User();
        user.setUserId(formDTO.getUserId());
        user.setEmailId(formDTO.getEmail());
        user.setName(formDTO.getFirstName());
        user.setPassword(formDTO.getPassword());
        final HashSet<Role> roles = new HashSet<Role>();
        Role role = new Role();
        role.setName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);
        user.setActive(1);
        user.setProvider(formDTO.getSocialProvider().name());
        return user;
    }
}
