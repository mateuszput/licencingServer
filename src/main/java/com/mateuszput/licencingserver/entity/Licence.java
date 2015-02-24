package com.mateuszput.licencingserver.entity;

import static javax.persistence.InheritanceType.JOINED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = JOINED)
public class Licence {
	private long id;
	//TODO: sprawdzic czy name jest potrzebne?
	private String name;
	private String licenceSignature;
	private Application application;
	private String computerSignature;
	
	Licence(){
	}
	
	public Licence(String name) {
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
	
	@Column(name = "licence_name", length = 200, nullable = false)
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name = "licence_signature", length = 100, nullable = false, unique = true)
	public String getLicenceSignature(){
		return licenceSignature;
	}
	
	public void setLicenceSignature(String licenceSignature){
		this.licenceSignature = licenceSignature;
	}
	
	@ManyToOne
    @JoinColumn(name = "app_id")
	public Application getApplication(){
		return application;
	}
	
	public void setApplication(Application application){
		this.application = application;
	}
	
	@Column(name = "computer_signature", length = 200, nullable = true)
	public String getComputerSignature(){
		return computerSignature;
	}
	
	public void setComputerSignature(String computerSignature){
		this.computerSignature = computerSignature;
	}
}
