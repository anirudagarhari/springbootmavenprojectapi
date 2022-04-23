package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employe;
import com.example.demo.services.Employservice;

@Controller

public class Employecontroller {
	@Autowired
	private Employservice  employeservice;
	//display list of employes
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmpolye",employeservice.getAllEmploye());
		return "index";
		
	}
	@GetMapping("/showNewEmployForm")
	public String showNewEmployForm(Model model) {
		
		Employe employe=new Employe();
		model.addAttribute("employe",employe);
		return "new_employe";
	}
	
	@PostMapping("/saveEmploye")
	public String saveEmploye(@ModelAttribute("employe")Employe employe)
	{
		//save employe to database
		employeservice.saveEmploye(employe);
		return "redirect:/";
		
	}

	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id ,Model model)
	{
		//get employe from the service
		Employe employe=employeservice.getEmployeById(id);
		//set employe as a model attribute to pre-populate the form
		model.addAttribute("employe",employe);
		return "update_employee";
		
	}
	
	@GetMapping("/deleteEmploye/{id}")
	public String deleteEmploye(@PathVariable(value ="id") long id) {
		//call delete
		this.employeservice.deleteEmployeById(id);
		return "redirect:/";
		
	}
	}


