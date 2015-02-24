package com.mateuszput.licencingserver.dao;

import java.util.List;

import com.mateuszput.licencingserver.entity.Application;
import com.mateuszput.licencingserver.entity.Owner;

public interface OwnerDAO {
	public List<Owner> getAll(); 
	public void saveOwner() throws Exception;
	public void addOwner(Owner owner) throws Exception;
//	public void addApplication(Application application, String ownerSignature);
//	public void addApplication(Application application);
	
	public void updateOwner(Owner owner) throws Exception;
	public Owner getOwner(String ownerSignature);
	public Application getApplication(String applicationSignature);
	public void updateApplication(Application application) throws Exception;
}
