package com.mateuszput.licencingserver.web.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mateuszput.licencingserver.dao.OwnerDAO;
import com.mateuszput.licencingserver.entity.Owner;

@Controller
public class WelcomeController implements ApplicationContextAware{
	protected final Log logger = LogFactory.getLog(getClass());
	
	private ApplicationContext applicationContext;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/welcome")
	public ModelAndView welcome() throws SQLException{
		logger.info("-- Request controller");
		
		OwnerDAO ownerDAO = (OwnerDAO) applicationContext.getBean("ownerDao");
		
		try {
			ownerDAO.saveOwner();
		} catch (Exception e) {
			return new ModelAndView("addOwnerError");
		}
		List<Owner> owners = ownerDAO.getAll();

//		for (Owner owner : owners) {
//			logger.info("-- App size: " + owner.getApplications().size());
//		  for(Application app : owner.getApplications()){
//        	logger.info("App: " + app.getName());
//          	
////      	for(Licence lic : app.getLicence()){
////  		System.out.println(" Lic: " + lic.getName());
////  	}
//          }
//      }
		
		
		Map dataMap = new HashMap();
		Owner owner = owners.get(0);
		dataMap.put("owners", owners);
		dataMap.put("owner", owner);
		dataMap.put("ownersSize", owners.size());
//		return new ModelAndView("welcome.jsp", dataMap);
		return new ModelAndView("welcome", dataMap);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	
//    public static void displayData(Session session) {
//        Query pubQuery = session.createQuery("from Owner");
//
//        List<Owner> owners = (List<Owner>) pubQuery.list();
//        System.out.println("Identified " + owners.size() + " owners");
//        System.out.println();
//
//        for (Owner owner : owners) {
//            System.out.println("Owner: " + owner.getName());
//            
//            for(Application app : owner.getApplications()){
//            	System.out.println("App: " + app.getName());
//            	
//            	for(Licence lic : app.getLicence()){
//            		System.out.println(" Lic: " + lic.getName());
//            	}
//            }
//        }
//    }
}

