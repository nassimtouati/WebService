package com.WebService.tn.service;

import java.util.List;

import com.WebService.tn.database.model.Users;

public interface UsersService {
    public boolean saveOrUpdate(Users users);
 
    public List<Users> list();
 
    public boolean delete(Users users);
}
