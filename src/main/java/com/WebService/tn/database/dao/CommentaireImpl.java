package com.WebService.tn.database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.WebService.tn.database.model.Commentaire;


@Repository
@Transactional
public class CommentaireImpl implements CommentaireDao {

	@Autowired
	SessionFactory session;
	
	@Override
	public void ajouterCom(Commentaire comm) {
		session.getCurrentSession().persist(comm);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commentaire> afficherCommentaire(String group_name) {
		
		return session.getCurrentSession().createQuery("from Commentaire where groupe='"+group_name+"'").list();
	}
	
	
	

}
