package com.WebService.tn.database.dao;

import java.util.List;

import com.WebService.tn.database.model.Commentaire;

public interface CommentaireDao {
	public List <Commentaire>afficherCommentaire(String group_name);
	public void ajouterCom(Commentaire comm);
	
}
