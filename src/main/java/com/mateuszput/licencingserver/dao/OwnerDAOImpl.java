package com.mateuszput.licencingserver.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mateuszput.licencingserver.entity.Application;
import com.mateuszput.licencingserver.entity.Licence;
import com.mateuszput.licencingserver.entity.Owner;

public class OwnerDAOImpl extends HibernateDaoSupport implements OwnerDAO{

	@SuppressWarnings("unchecked")
	public List<Owner> getAll() {
		Session session = getSession();
		List<Owner> owners = (List<Owner>)session.createQuery("from Owner").list();
		releaseSession(session);
		return owners;
	}
	
	//TODO: podczas dodawania licencji moze wystapic ConstraintViolationException, ustawilem unique licenceSignature 
	public void saveOwner() throws Exception{
		Transaction tx = null;
		Session session = getSession();
		tx = session.beginTransaction();
		
		Owner owner = new Owner("Mateusz 1");
		owner.setLogin("m login");
		owner.setOwnerSignature("OWNER002");
		Application application = new Application("Aplikacja 1");
		application.setApplicationSignature("APP002");
    	// licencja 1
		Licence licence = new Licence("Licencja 1");
		licence.setComputerSignature("0343897DA3");
		licence.setLicenceSignature("LIC003");
    	licence.setApplication(application);
    	application.getLicences().add(licence);
    	// licencja 2
    	licence = new Licence("Licencja 2");
    	licence.setApplication(application);
    	licence.setLicenceSignature("LIC004");
    	application.getLicences().add(licence);
    	// aplikacja
    	application.setOwner(owner);
    	owner.getApplications().add(application);
    	
    	System.out.println("--> a1");
    	
		session.save(owner);
		System.out.println("--> a2");
		tx.commit();
		
		releaseSession(session);
	}
	
	public void addOwner(Owner owner) throws Exception{
		Transaction tx = null;
		Session session = getSession();
		tx = session.beginTransaction();
		
		String ownerSignature = owner.getLogin();
		owner.setOwnerSignature(ownerSignature);
//		System.out.println("ID: " + owner.getId() + ", login: " + owner.getLogin() + ", name: " +  owner.getName()  + ", sign: " + owner.getOwnerSignature());
		session.save(owner);
		tx.commit();
		releaseSession(session);
	}
	
	public Owner getOwner(String ownerSignature){
		Session session = getSession();
		Query query = session.createQuery("from Owner where ownerSignature = ?");
		query.setString(0, ownerSignature);
		Owner owner = (Owner) query.uniqueResult();
		releaseSession(session);
		return owner;
	}
	
	/**
	 * 
	 * @param licenceSignature -
	 * @return
	 */
	public Licence getLicence(String licenceSignature){
		Session session = getSession();
		Query query = session.createQuery("from Licence where licenceSignature = ?");
		query.setString(0, licenceSignature);
		Licence licence = (Licence) query.uniqueResult();
		releaseSession(session);
		return licence;
	}
	
	public Licence setComputerSignature(Licence licence, String computerSignature){
		Transaction tx = null;
		Session session = getSession();
		tx = session.beginTransaction();
		licence.setComputerSignature(computerSignature);
		session.update(licence);
//		session.save(licence);
		tx.commit();
		releaseSession(session);
		
		return licence;
	}
	
	public Application getApplication(String applicationSignature){
		Session session = getSession();
		Query query = session.createQuery("from Application where applicationSignature = ?");
		query.setString(0, applicationSignature);
		Application application = (Application) query.uniqueResult();
		releaseSession(session);
		return application;
	}
	

//	public void addApplication(Application application) {
//		// TODO Auto-generated method stub
//		Transaction tx = null;
//		Session session = getSession();
//		tx = session.beginTransaction();
//		
//		application.get
//		String ownerSignature = owner.getLogin() + "Signature";
//		owner.setOwnerSignature(ownerSignature);
//		session.save(owner);
//		tx.commit();
//		releaseSession(session);
//	}
	
	
	public void updateApplication(Application application) throws Exception{
		Transaction tx = null;
		Session session = getSession();
		tx = session.beginTransaction();
		
		session.update(application);
		tx.commit();
		releaseSession(session);
	}
	
	
	public void updateOwner(Owner owner) throws Exception{
		Transaction tx = null;
		Session session = getSession();
		tx = session.beginTransaction();
		
		session.update(owner);
		tx.commit();
		releaseSession(session);
	}
	
}
