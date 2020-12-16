package com.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojoninja.models.Dojo;
import com.dojoninja.models.Ninja;
import com.dojoninja.services.DojoService;
import com.dojoninja.services.NinjaService;

@Controller
public class MainController {
	//dependency injection
	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	//ROUTES - same as the APIcontroller
//	@RequestMapping("/", method=RequestMethod.GET)
//	@RequestMapping("/")
	@GetMapping("/")
	public String index() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {//need model to display to frontend from DB
		List<Dojo> allDojos = this.dojoService.getAllDojos();//store everything in a list
		viewModel.addAttribute("allDojos", allDojos);
		
		return "add.jsp";
	}

	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {//need model to display to frontend from DB
//		List<Ninja> allDLs = this.DLService.getAllDLs();//store everything in a list
//		viewModel.addAttribute("allDLs", allDLs);
		
		return "addDojo.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {//need model to display to frontend from DB
		List<Dojo> allDojos = this.dojoService.getAllDojos();//store everything in a list
		viewModel.addAttribute("allDojos", allDojos);
		
		return "dashboard.jsp";
	}

	//show specific Dojo
	@GetMapping("/showDojo/{id}")
	public String showDojo(Model viewModel, @PathVariable("id") Long id) {//need model to display to frontend from DB
		viewModel.addAttribute("dojo", dojoService.getSingleDojo(id));
		
		return "showDojo.jsp";
	}

	
	
	//Create new ninja
	//Have a method handler in the controller for the following example url: /ninjas/create?firstName=John&lastName=Doe&age=35
	@PostMapping("/ninjas/create")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja) {
		//the @Valid will check against the validations created in DL.java
		//BindingResult is if something goes wrong in the validation from the DLs, BindingResult will catch it
		// if(result.hasErrors()) {
		// 	return "add.jsp";//re-render the page if there are errors
		// }
		//get the id of the ninja so we can assign that foreign key, alternate would be to use a hidden field in the form- this is better so the user can't alter the hidden field with devtools
		Long dojoId = ninja.getDojo().getId();

		this.ninjaService.createNinja(ninja);
		return "redirect:/dashboard";
	}

	
	//Create new dojo
	//Have a method handler in the controller for the following example url: /dojos/create?ninja=1&address=1234%20Some%20Street&city=Los%20Angeles&state=CA. The ninja query parameter should be the id of the ninja in the database. Create the dojo info for the ninjas from the previous task. (%20 is the encoding for SPACE in query parameters)
	@PostMapping("/dojos/create")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo) {

		this.dojoService.createDojo(dojo);
		
		return "redirect:/dashboard";
	}

	//delete
	@GetMapping("/delete/{id}")
	public String deleteDojo(@PathVariable("id") Long id) {
		this.dojoService.deleteDojo(id);
		
		return "redirect:/dashboard";
	}

	
}
