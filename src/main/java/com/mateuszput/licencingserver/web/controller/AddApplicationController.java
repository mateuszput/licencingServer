package com.mateuszput.licencingserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mateuszput.licencingserver.command.ApplicationCommand;
import com.mateuszput.licencingserver.dao.OwnerDAO;
import com.mateuszput.licencingserver.entity.Application;
import com.mateuszput.licencingserver.entity.Owner;

@Controller
@RequestMapping("/addApplication.htm")
@SessionAttributes("applicationCommand")
public class AddApplicationController {

	@Autowired
	private OwnerDAO ownerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String showApplicationForm(ModelMap model)	{
		ApplicationCommand applicationCommand = new ApplicationCommand();
		model.addAttribute(applicationCommand);
		return "addApplicationForm";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("applicationCommand") ApplicationCommand applicationCommand) {
		String returnLink = "redirect:addApplicationSuccess.htm";
		
		//TODO: czy to powinno byc tutaj, czy moze w DAO (ownerDAO)?
		Owner owner = ownerDAO.getOwner(applicationCommand.getOwnerSignature());
		if(owner == null) {
			returnLink = "redirect:addApplicationError.htm";
		} else {
			Application application = new Application(applicationCommand.getName());
			
			application.setOwner(owner);
			application.setApplicationSignature(applicationCommand.getName());
			
			owner.getApplications().add(application);
			
			try {
				ownerDAO.updateOwner(owner);
			} catch (Exception e) {
				returnLink = "redirect:addApplicationError.htm";
			}
		}
		
		
		return returnLink;
	}
}
