package com.mateuszput.licencingserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mateuszput.licencingserver.dao.OwnerDAO;
import com.mateuszput.licencingserver.entity.Owner;

@Controller
@RequestMapping("/selectOwnerForm.htm")
@SessionAttributes("owner")
public class SelectOwnerController {

	@Autowired
	private OwnerDAO ownerDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showOwnerForm(ModelMap model)	{
		Owner owner = new Owner();
		model.addAttribute(owner);
		return "selectOwnerForm";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("owner") Owner owner) {
		String returnLink = "redirect:showOwnerApplications.htm";
		
		owner = ownerDAO.getOwner(owner.getOwnerSignature());
		System.out.println("--> owner: " + owner.getName());
		
		if(owner == null){
			returnLink = "redirect:addOwnerError.htm";
		}
		
		return returnLink;
	}
}
