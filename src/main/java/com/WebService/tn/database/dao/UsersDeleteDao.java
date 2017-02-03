package com.WebService.tn.database.dao;

import java.util.List;

import com.WebService.tn.database.model.User;

public interface UsersDeleteDao {
	 public boolean saveOrUpdate(User user);
	 
	    public List<User> list();
	 
	    public boolean delete(User user);
	}
