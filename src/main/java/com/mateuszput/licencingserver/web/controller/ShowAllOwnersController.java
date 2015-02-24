package com.mateuszput.licencingserver.web.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mateuszput.licencingserver.dao.OwnerDAO;
import com.mateuszput.licencingserver.entity.Owner;

@Controller
public class ShowAllOwnersController {
	
	@Autowired
	private OwnerDAO ownerDAO;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/showAllOwners.htm")
	public ModelAndView welcome() throws SQLException{
		List<Owner> owners = ownerDAO.getAll();

		Map dataMap = new HashMap();
		dataMap.put("owners", owners);
		dataMap.put("ownersSize", owners.size());
		return new ModelAndView("allOwners", dataMap);
	}
}
