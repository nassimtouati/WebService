package com.WebService.tn.database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.WebService.tn.database.dao.UsersDeleteDao;
import com.WebService.tn.database.model.User;

@Repository
@Transactional
public class UsersDeleteImpl implements UsersDeleteDao {
 
    @Autowired
    SessionFactory session;
 
    public boolean saveOrUpdate(User user) {
        // TODO Auto-generated method stub
        session.getCurrentSession().saveOrUpdate(user);
        return true;
    }
 
    public List<User> list() {
        return session.getCurrentSession().createQuery("from User").list();
    }
 
    public boolean delete(User user) {
        try {
            session.getCurrentSession().delete(user);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
    }
}
