package com.mateuszput.licencingserver.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO: do wyrzucena
@Controller
public class SelectOSuccessController {
	@RequestMapping("/selectOSuccess.htm")
	public String redirect() {
		return "selectOSuccess";
	}
}