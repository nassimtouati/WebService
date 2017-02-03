package com.WebService.tn.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebService.tn.database.dao.UsersDeleteDao;
import com.WebService.tn.database.model.User;
import com.WebService.tn.service.UsersDeleteServices;

@Service
public class UsersDeleteServiceImpl implements UsersDeleteServices {
 
    @Autowired
    UsersDeleteDao userDao1;
 
    public boolean saveOrUpdate(User user) {
        return userDao1.saveOrUpdate(user);
    }
 
    public List<User> list() {
        // TODO Auto-generated method stub
        return userDao1.list();
    }
 
    public boolean delete(User user) {
        // TODO Auto-generated method stub
        return userDao1.delete(user);
    }
 
}
