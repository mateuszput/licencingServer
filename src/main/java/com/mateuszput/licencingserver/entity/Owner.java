package com.mateuszput.licencingserver.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Owner {
	
	private long id;
	private String login;
	private String name;
	private String ownerSignature;
	private Set<Application> applications = new HashSet<Application>();
	private Set<Application> _applications;
	
	public Owner(){
	}
	
	
	public Owner(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	@Column(length = 20, nullable = false, unique = true)
	public String getLogin(){
		return login;
	}
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name = "owner_signature", length = 100, nullable = false, unique = true)
	public String getOwnerSignature(){
		return ownerSignature;
	}
	
	public void setOwnerSignature(String ownerSignature){
		this.ownerSignature = ownerSignature;
	}
	
	@OneToMany(cascade = ALL, mappedBy = "owner")
	public Set<Application> getApplications(){
		return applications;
	}
	
//	public void setApplications(Set<Application> applications) {
//        this.applications = applications;
//    }
	
	/**
	 * Hack - zeby nie bylo lazy initiation exception
	 */
	public void setApplications(Set<Application> applications) {
		this.applications = applications;
		this._applications = new HashSet(applications);
	}
}
