package com.spring.recipeweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.recipeweb.repository.CategoryRepository;
import com.spring.recipeweb.repository.UnitOfMeasureRepository;
import com.spring.recipeweb.services.RecipeService;

@Controller
public class IndexController {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@RequestMapping("/index")
	public String getIndexPage(Model model){
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
}