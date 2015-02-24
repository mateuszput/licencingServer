package com.mateuszput.licencingserver.command;

import java.io.Serializable;

public class ApplicationCommand implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1621835956706231391L;
	private String name;
	private String applicationSignature;
	private String ownerSignature;
	
	public ApplicationCommand(){
	}
	
//	public ApplicationCommand(String name) {
//		this.name = name;
//	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getApplicationSignature(){
		return applicationSignature;
	}
	
	public void setApplicationSignature(String applicationSignature){
		this.applicationSignature = applicationSignature;
	}
	
	public String getOwnerSignature(){
		return ownerSignature;
	}
	
	public void setOwnerSignature(String ownerSignature){
		this.ownerSignature = ownerSignature;
	}
	
}
