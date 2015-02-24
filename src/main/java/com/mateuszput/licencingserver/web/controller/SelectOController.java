package com.mateuszput.licencingserver.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mateuszput.licencingserver.dao.OwnerDAO;
import com.mateuszput.licencingserver.entity.Owner;


//TODO: do wyrzucena
@Controller
@RequestMapping("/selectO.htm")
//@SessionAttributes("owner")
public class SelectOController{

	@Autowired
	private OwnerDAO ownerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String showOwnerForm(ModelMap model)	{
		Owner owner = new Owner();
		model.addAttribute(owner);
		return "selectOForm";
	}

	
	/**
	 * W tej metodzie chcemy zeby przy odswierzeniu na nowo przesylal dane,
	 * nie dodajemy do bazy tylko pokazujemy wyniki. Jak ktos odswierzy a wyniki
	 * zostana zmienione w miedzyczasie, to dzieki temu pokaze aktualne wyniki. 
	 * @param owner
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("owner") Owner owner) {
//		@ModelAttribute("owner")
		String returnLink = "redirect:selectOSuccess.htm";
		
//		owner = ownerDAO.getOwner(owner.getOwnerSignature());
//		System.out.println("--> owner: " + owner.getName());
		
		
//		String ownerSignature = "mateusz";
//		Owner owner = ownerDAO.getOwner(ownerSignature);
//		
//		Map dataMap = new HashMap();
//		dataMap.put("owner", owner);
//		return new ModelAndView("showOwnerApplications", dataMap);
		
		System.out.println("--> show owner app.");
		Map dataMap = new HashMap();
		Owner ownerTest = ownerDAO.getOwner(owner.getOwnerSignature());
//		dataMap.put("owners", owners);
		dataMap.put("owner", ownerTest);
//		dataMap.put("ownersSize", owners.size());
		return new ModelAndView("selectOSuccess", dataMap);
		
	}

	
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String onSubmit(@ModelAttribute("owner") Owner owner) {
//		String returnLink = "redirect:selectOSuccess.htm";
//		
//		owner = ownerDAO.getOwner(owner.getOwnerSignature());
//		System.out.println("--> owner: " + owner.getName());
//		
//		
////		String ownerSignature = "mateusz";
////		Owner owner = ownerDAO.getOwner(ownerSignature);
////		
////		Map dataMap = new HashMap();
////		dataMap.put("owner", owner);
////		return new ModelAndView("showOwnerApplications", dataMap);
//		
//		
//		return returnLink;
//	}
	


}
