package com.vcabading.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/////////////////////////////////////////////////////////////////
//	DOJOS AND NINJAS CONTROLLER
/////////////////////////////////////////////////////////////////

@Controller
public class DojosandninjasController {
	@GetMapping("/dojos")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/ninjas/new")
	public String ninjasNew() {
		return "ninjasnew.jsp";
	}
	
	//	//// CREATE /////////////////////////////////////////////////

		
	//	//// RETRIEVE ///////////////////////////////////////////////

	@GetMapping("/dojos/new")
	public String dojosNew() {
			return "dojosnew.jsp";
	}

	@GetMapping("/dojos/{id}")
	public String dojosId(@PathVariable("id") Long id) {
		return "dojosid.jsp";
	}
		
	//	//// UPDATE /////////////////////////////////////////////////

	

	//	//// DELETE /////////////////////////////////////////////////

}