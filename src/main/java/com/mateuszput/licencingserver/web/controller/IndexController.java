package com.mateuszput.licencingserver.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/index.htm")
public class IndexController {

//	@RequestMapping(method = RequestMethod.GET)
	@RequestMapping("/index.htm")
	public String showLinks(ModelMap model)	{
//		ApplicationCommand applicationCommand = new ApplicationCommand();
//		model.addAttribute(applicationCommand);
		return "index";
	}
}
