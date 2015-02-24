package com.mateuszput.licencingserver.command;

public class LicenceCommand {
	
	private String name;
	private String licenceSignature;
	private String applicationSignature;

	public LicenceCommand(){
	}
	

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
	
	public String getLicenceSignature(){
		return licenceSignature;
	}
	
	public void setLicenceSignature(String licenceSignature){
		this.licenceSignature = licenceSignature;
	}

}
