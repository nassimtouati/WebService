package com.WebService.tn.database.dao;

import java.util.List;

import com.WebService.tn.database.model.Users;

public interface UsersDao {
    public boolean saveOrUpdate(Users users);
 
    public List<Users> list();
 
    public boolean delete(Users users);
}
