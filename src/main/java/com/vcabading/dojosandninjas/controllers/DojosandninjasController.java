package com.vcabading.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/////////////////////////////////////////////////////////////////
//	DOJOS AND NINJAS CONTROLLER
/////////////////////////////////////////////////////////////////

@Controller
@RequestMapping("/dojos")
public class DojosandninjasController {
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
}