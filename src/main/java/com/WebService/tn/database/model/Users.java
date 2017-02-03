package com.WebService.tn.database.model;


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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Integer user_id;
 
    @Column(name = "first_name")
    private String first_name;
 
	@Column(name = "last_name")
    private String last_name;
	
    @Column(name = "email")
    private String email;
 
    @Column(name = "biography")
    private String biography;
    @Column(name = "groups")
    private String groups;
    
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    
    public Integer getUser_id() {
        return user_id;
    }
 
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
 
    public String getfirst_name() {
        return first_name;
    }
 
    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }
 
 public String getlast_name() {
        return last_name;
    }
 
    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }
	
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    public String getbiography() {
        return biography;
    }
 
    public void setbiography(String biography) {
        this.biography = biography;
    }
    public String getgroups() {
        return groups;
    }
 
    public void setgroups(String groups) {
        this.groups = groups;
    }
}