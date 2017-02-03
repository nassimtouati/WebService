package com.WebService.tn.service;

import java.util.List;

import com.WebService.tn.database.model.User;

public interface UsersDeleteServices {
	public boolean saveOrUpdate(User user);
	 
    public List<User> list();
 
    public boolean delete(User user);
}

