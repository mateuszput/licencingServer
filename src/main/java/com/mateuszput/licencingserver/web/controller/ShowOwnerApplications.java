package com.mateuszput.licencingserver.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowOwnerApplications {

	@RequestMapping("/showOwnerApplications.htm")
	public String redirect() {
		System.out.println("--> show owner app.");
		return "showOwnerApplications";
	}
}
