package com.vcabading.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.vcabading.dojosandninjas.models.Dojo;
import com.vcabading.dojosandninjas.services.DojoService;
import com.vcabading.dojosandninjas.services.NinjaService;

/////////////////////////////////////////////////////////////////////
//	DOJOS AND NINJAS CONTROLLER
/////////////////////////////////////////////////////////////////////

@Controller
public class DojosandninjasController {
	
	//	//// FIELDS /////////////////////////////////////////////////
	
	@Autowired
	DojoService dojoServ;
	
	@Autowired
	NinjaService ninjaServ;
	
	//	//// SHOW ///////////////////////////////////////////////////
	
	@GetMapping("/ninjas/new")
	public String ninjasNew() {
		return "ninjasnew.jsp";
	}
	
	//	//// CREATE /////////////////////////////////////////////////

		
	//	//// RETRIEVE ///////////////////////////////////////////////

	@GetMapping("/dojos")
	public String index(Model model) {
		List<Dojo> dojosList = this.dojoServ.retrieveAll();
		model.addAttribute("dojosList", dojosList);
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String dojosNew(@ModelAttribute("dojo") Dojo dojo) {
			return "dojosnew.jsp";
	}

	@GetMapping("/dojos/{id}")
	public String dojosId(@PathVariable("id") Long id) {
		return "dojosid.jsp";
	}
		
	//	//// UPDATE /////////////////////////////////////////////////

	

	//	//// DELETE /////////////////////////////////////////////////

}