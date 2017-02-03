package com.WebService.tn.database.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groupes")
public class Groupes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="groupe_id")
	private Integer groupe_id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="name")
	private String name;
	
	@Column(name="admin")
	private String admin;
	
	@Column(name="members")
	private String members;

	public Integer getGroupe_id() {
		return groupe_id;
	}

	public void setGroupe_id(Integer groupe_id) {
		this.groupe_id = groupe_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	public String getmembers() {
		return members;
	}

	public void setmembers(String members) {
		this.members = members;
	}
	
}
