package com.WebService.tn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebService.tn.database.dao.GroupesDao;
import com.WebService.tn.database.model.Groupes;

import com.WebService.tn.service.GroupesService;

@Service
public class GroupesServiceImpl implements GroupesService {
	@Autowired
    GroupesDao groupesDao;
	
	 public boolean saveOrUpdate(Groupes groupes) {
	        return groupesDao.saveOrUpdate(groupes);
	    }
	    public List<Groupes> list(String admin) {
	        // TODO Auto-generated method stub
	        return groupesDao.list(admin);
	    }
	 
	    public boolean delete(Groupes groupes) {
	        // TODO Auto-generated method stub
	        return groupesDao.delete(groupes);
	    }
		
		public List<Groupes> listTout(String admin) {
			
			return groupesDao.listTout(admin);
		}
		@Override
		public List<Groupes> listgroupe() {
			
			return groupesDao.listgroupe();
		}
	
}
