package com.mateuszput.licencingserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mateuszput.licencingserver.command.LicenceCommand;
import com.mateuszput.licencingserver.dao.OwnerDAO;
import com.mateuszput.licencingserver.entity.Application;
import com.mateuszput.licencingserver.entity.Licence;

@Controller
@RequestMapping("/addLicence.htm")
@SessionAttributes("licenceCommand")
public class AddLicenceController {
	
	
	@Autowired
	private OwnerDAO ownerDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showLicenceForm(ModelMap model)	{
		LicenceCommand licenceCommand = new LicenceCommand();
		model.addAttribute(licenceCommand);
		return "addLicenceForm";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("licenceCommand") LicenceCommand licenceCommand) {
		String returnLink = "redirect:addLicenceError.htm";
		
		Application application = ownerDAO.getApplication(licenceCommand.getApplicationSignature());
		if(application != null) {
			returnLink = "redirect:addLicenceSuccess.htm";
			Licence licence = new Licence(licenceCommand.getName());
			licence.setApplication(application);
			licence.setLicenceSignature(licenceCommand.getLicenceSignature());
			
			application.getLicences().add(licence);
			
			try {
				ownerDAO.updateApplication(application);
			} catch (Exception e) {
				returnLink = "redirect:addLicenceError.htm";
			}
		}
		return returnLink;
	}
}
