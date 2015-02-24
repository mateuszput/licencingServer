package com.mateuszput.licencingserver.webservice;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.mateuszput.licencingserver.dao.OwnerDAOImpl;
import com.mateuszput.licencingserver.entity.Licence;

//TODO: przeniesc do odpowiedniej klasy, stworzyc dla niej interface, usunac calosc
@WebService(serviceName="CheckLicenceService")
public class CheckLicence extends SpringBeanAutowiringSupport{
	@Resource
	private WebServiceContext wsCtxt;

	@Autowired
	private OwnerDAOImpl ownerDao;
	
	@WebMethod
	public boolean checkLicence(String licenceSignature, String computerSignature) {
		Licence licence = ownerDao.getLicence(licenceSignature);
		
		Boolean licenceCorrect = false;
		if (licence != null){
			if(licence.getComputerSignature() != null){
				Boolean computerSignaturesEqual = (licence.getComputerSignature().compareTo(computerSignature) == 0);
				licenceCorrect = computerSignaturesEqual;
			}
		}
		return licenceCorrect;
	}
	
	
	@WebMethod
	public boolean registerLicence(String licenceSignature, String computerSignature, String applicationSignature, String ownerSignature) {
		Licence licence = ownerDao.getLicence(licenceSignature);

		Boolean correctRegistration = false;
		if (licence != null){
			Boolean applicationSignaturesEqual = (licence.getApplication().getApplicationSignature().compareTo(applicationSignature) == 0);
			Boolean ownerSignaturesEqual = (licence.getApplication().getOwner().getOwnerSignature().compareTo(ownerSignature) == 0);
			
			if(applicationSignaturesEqual && ownerSignaturesEqual){
				if(licence.getComputerSignature() == null){
					ownerDao.setComputerSignature(licence, computerSignature);
					correctRegistration = true;
				} else {
					Boolean computerSignaturesEqual = (licence.getComputerSignature().compareTo(computerSignature) == 0);
					correctRegistration = computerSignaturesEqual;
				}
			} 
		}
		
		return correctRegistration;
	}

}
