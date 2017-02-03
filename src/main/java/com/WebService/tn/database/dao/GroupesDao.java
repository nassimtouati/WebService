package com.WebService.tn.database.dao;
import java.util.List;

import com.WebService.tn.database.model.Groupes;


public interface GroupesDao {
	
	 public boolean saveOrUpdate(Groupes groupes);
	 
	    public List<Groupes> list( String admin);
	 
	    public boolean delete(Groupes groupes);
	    
	    public List<Groupes> listTout(String admin);
	    
	    public List<Groupes> listgroupe();
	    
	  

}
