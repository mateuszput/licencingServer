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
@RequestMapping("/addOwner.htm")
@SessionAttributes("owner")
public class AddOwnerController{

	@Autowired
	private OwnerDAO ownerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String showOwnerForm(ModelMap model)	{
		Owner owner = new Owner();
		model.addAttribute(owner);
		return "addOwnerForm";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("owner") Owner owner) {
		String returnLink = "redirect:addOwnerSuccess.htm";
		try {
			ownerDAO.addOwner(owner);
		} catch (Exception e) {
			returnLink = "redirect:addOwnerError.htm";
		}

		return returnLink;
	}
	

//	@Override
//	protected ModelAndView onSubmit(Object command) throws Exception {
//		Owner user = (Owner) command;
//		ownerDAO.addOwner(user);
//		return new ModelAndView("userSuccess", "user", user);
//	}

}
