package com.WebService.tn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebService.tn.database.dao.CommentaireDao;
import com.WebService.tn.database.model.Commentaire;

@Service
public class CommentaireServiceimpl implements CommentaireService {
	
	@Autowired
	CommentaireDao comDao;

	@Transactional
	public void ajouterCom(String group, String memebre, String comm) {
		
		Commentaire com=new Commentaire();
		
		com.setAuteur(memebre);
		com.setGroupe(group);
		com.setContent(comm);
		
		comDao.ajouterCom(com);
		
	}

	@Transactional
	public List<Commentaire> afficherCommentaire(String group_name) {
		
		return comDao.afficherCommentaire(group_name);
	}
	
	
	

}
