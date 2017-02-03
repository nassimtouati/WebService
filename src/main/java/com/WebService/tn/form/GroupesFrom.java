package com.WebService.tn.form;

import javax.persistence.Column;



public class GroupesFrom {

	private Integer groupe_id;
	
	private String description;
	
	private String name;

	private String admin;

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

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	
	
}
