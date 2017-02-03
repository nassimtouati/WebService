package com.WebService.tn.database.dao;

import java.util.List;

import com.WebService.tn.database.model.Memebers;

public interface MemberDao {
	
	public void ajouterMembre (String groupe_name, String memberName, String role);
	public List <Memebers>afficherMembers (String group_name);

}
