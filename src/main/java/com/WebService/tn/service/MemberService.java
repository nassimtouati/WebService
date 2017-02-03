package com.WebService.tn.service;

import java.util.List;

import com.WebService.tn.database.model.Memebers;

public interface MemberService {
	
	public void ajouterMembre (String groupe_name, String memberName, String role);
	public List <Memebers> afficherMembers (String group_name);
}
