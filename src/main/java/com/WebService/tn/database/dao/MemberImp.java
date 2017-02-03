package com.WebService.tn.database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.WebService.tn.database.model.Memebers;

@Repository
@Transactional
public class MemberImp implements MemberDao{
	
	@Autowired
	SessionFactory session;

	public void ajouterMembre( String groupe_name, String memberName, String role) {
		
		Memebers mbr= new Memebers();
	
		mbr.setNameGroup(groupe_name);
		mbr.setNameMember(memberName);
		mbr.setRole(role);
		session.getCurrentSession().save(mbr);
		
	}
	
	public List <Memebers> afficherMembers (String group_name){
		
		return session.getCurrentSession().createQuery("from Memebers where nameGroup='"+group_name+"'").list();
	}

}
