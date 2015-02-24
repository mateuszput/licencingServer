package com.mateuszput.licencingserver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BlockedIP {
	private long id;
	private String ipNumber;
	
	BlockedIP(){
	}
	
	public BlockedIP(String ipNumber) {
		this.ipNumber = ipNumber;
	}

	@Id
	@GeneratedValue
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getIpNumber(){
		return ipNumber;
	}
	
	public void setIpNumber(String ipNumber){
		this.ipNumber = ipNumber;
	}
	
}
