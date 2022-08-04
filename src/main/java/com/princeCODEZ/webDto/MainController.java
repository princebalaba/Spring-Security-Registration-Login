package com.princeCODEZ.webDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public  String login() {
		return "login";
	}

	//handler method for the home page after successful login	
	@GetMapping("/")
	public  String homePage() {
		return "index";
	}
}
