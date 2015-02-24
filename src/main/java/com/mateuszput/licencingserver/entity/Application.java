package com.mateuszput.licencingserver.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.InheritanceType.JOINED;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = JOINED)
public class Application {
	private long id;
	private String name;
	private String applicationSignature;
	private Owner owner;
	private Set<Licence> licences = new HashSet<Licence>();
	private Set<Licence> _licences;
	
	Application(){
	}
	
	public Application(String name) {
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
	
	@Column(name = "app_name", length = 200, nullable = false)
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name = "application_signature", length = 100, nullable = false, unique = true)
	public String getApplicationSignature(){
		return applicationSignature;
	}
	
	public void setApplicationSignature(String applicationSignature){
		this.applicationSignature = applicationSignature;
	}
	
	@ManyToOne
    @JoinColumn(name = "owner_id")
	public Owner getOwner(){
		return owner;
	}
	
	public void setOwner(Owner owner){
		this.owner = owner;
	}
	
	
	@OneToMany(cascade = ALL, mappedBy = "application")
	public Set<Licence> getLicences(){
		return licences;
	}
	
//	public void setLicences(Set<Licence> licences) {
//        this.licences = licences;
//    }
	
	/**
	 * Hack - zeby nie bylo lazy initiation exception
	 */
	public void setLicences(Set<Licence> licences) {
		this.licences = licences;
		this._licences = new HashSet(licences);
	}
}
