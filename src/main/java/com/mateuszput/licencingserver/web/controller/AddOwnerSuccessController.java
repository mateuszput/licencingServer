package com.mateuszput.licencingserver.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddOwnerSuccessController {
	@RequestMapping("/addOwnerSuccess.htm")
	public String redirect() {
		return "addOwnerSuccess";
	}
}
