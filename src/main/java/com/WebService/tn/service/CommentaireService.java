package com.WebService.tn.service;

import java.util.List;

import com.WebService.tn.database.model.Commentaire;

public interface CommentaireService {

	public List <Commentaire>afficherCommentaire(String group_name);
	public void ajouterCom(String group, String memebre, String comm);
}
