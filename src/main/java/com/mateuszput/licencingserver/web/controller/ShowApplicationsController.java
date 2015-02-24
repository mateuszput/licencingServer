package com.mateuszput.licencingserver.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mateuszput.licencingserver.dao.OwnerDAO;
import com.mateuszput.licencingserver.entity.Owner;


@Controller
@RequestMapping("/selectOwnerApplication.htm")
public class ShowApplicationsController{

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
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("owner") Owner owner) {
		
		System.out.println("--> show owner app.");
		Map dataMap = new HashMap();
		Owner ownerTest = ownerDAO.getOwner(owner.getOwnerSignature());
		dataMap.put("owner", ownerTest);
		return new ModelAndView("selectOSuccess", dataMap);
	}
	
}
