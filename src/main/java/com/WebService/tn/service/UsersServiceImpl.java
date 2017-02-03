package com.WebService.tn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebService.tn.database.dao.UsersDao;
import com.WebService.tn.database.model.Users;
import com.WebService.tn.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
 
    @Autowired
    UsersDao userDao;
 
    public boolean saveOrUpdate(Users users) {
        return userDao.saveOrUpdate(users);
    }
 
    public List<Users> list() {
        // TODO Auto-generated method stub
        return userDao.list();
    }
 
    public boolean delete(Users users) {
        // TODO Auto-generated method stub
        return userDao.delete(users);
    }
 
}