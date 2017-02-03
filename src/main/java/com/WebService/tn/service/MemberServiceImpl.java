package com.WebService.tn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebService.tn.database.dao.MemberDao;
import com.WebService.tn.database.model.Memebers;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;
	
	 @Transactional
	public void ajouterMembre( String groupe_name, String memberName, String role) {
		dao.ajouterMembre( groupe_name, memberName, role);
		
	}
	 
	 @Transactional
	 public List<Memebers> afficherMembers(String groupName){
		 
		 return dao.afficherMembers(groupName);
		 
	 }

	
	
}
