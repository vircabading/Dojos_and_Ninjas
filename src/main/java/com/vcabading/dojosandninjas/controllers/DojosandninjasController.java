package com.vcabading.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vcabading.dojosandninjas.models.Dojo;
import com.vcabading.dojosandninjas.models.Ninja;
import com.vcabading.dojosandninjas.services.DojoService;
import com.vcabading.dojosandninjas.services.NinjaService;

/////////////////////////////////////////////////////////////////////
//	DOJOS AND NINJAS CONTROLLER
/////////////////////////////////////////////////////////////////////

@Controller
public class DojosandninjasController {

	// //// FIELDS /////////////////////////////////////////////////

	@Autowired
	DojoService dojoServ;

	@Autowired
	NinjaService ninjaServ;

	// //// SHOW ///////////////////////////////////////////////////


	@GetMapping("/dojos/new")
	public String dojosNew(@ModelAttribute("dojo") Dojo dojo) {
		return "dojosnew.jsp";
	}

	// //// CREATE /////////////////////////////////////////////////

	@PostMapping("/dojos/new")
	public String dojosNewPost(@Valid @ModelAttribute("dojo") Dojo dojo,
				BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojosList = this.dojoServ.retrieveAll();
			model.addAttribute("dojosList",dojosList);
			return "dojosnew.jsp";
		} else {
			this.dojoServ.create(dojo);
			return "redirect:/dojos";
		}
    }
	
	@PostMapping("/ninjas/new")
	public String ninjasNewPost(@Valid @ModelAttribute("ninja") Ninja ninja,
				BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojosList = this.dojoServ.retrieveAll();
			model.addAttribute("dojosList",dojosList);
			return "ninjasnew.jsp";
		} else {
			this.ninjaServ.create(ninja);
			return "redirect:/dojos";
		}
    }

	// //// RETRIEVE ///////////////////////////////////////////////

	// **** Display All Dojos in the Index Page ********************
	@GetMapping("/dojos")
	public String index(Model model) {
		List<Dojo> dojosList = this.dojoServ.retrieveAll();
		model.addAttribute("dojosList", dojosList);
		return "index.jsp";
	}

	// **** Display all the Ninjas of a Dojo ***********************
	@GetMapping("/dojos/{id}")
	public String dojosId(@PathVariable("id") Long id, Model model) {
		Dojo dojo = this.dojoServ.retrieveDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojosid.jsp";
	}

	// **** Create a Form to Add a New Ninja to a Dojo *************
	@GetMapping("/ninjas/new")
	public String ninjasNew(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojosList = this.dojoServ.retrieveAll();
		model.addAttribute("dojosList", dojosList);
		return "ninjasnew.jsp";
	}

	// //// UPDATE /////////////////////////////////////////////////

	// //// DELETE /////////////////////////////////////////////////

}