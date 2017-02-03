package com.WebService.tn.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commentaire")
public class Commentaire {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="com_id")
	private Integer com_id;
	
	@Column(name="auteur")
	private String auteur;
	
	@Column(name="groupe")
	private String groupe;
	
	@Column(name="content")
	private String content;

	public Integer getCom_id() {
		return com_id;
	}

	public void setCom_id(Integer com_id) {
		this.com_id = com_id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
}
