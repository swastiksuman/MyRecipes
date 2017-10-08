package com.spring.recipeweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.recipeweb.bootstrap.RecipeBootstrap;
import com.spring.recipeweb.repository.CategoryRepository;
import com.spring.recipeweb.repository.RecipeRepository;
import com.spring.recipeweb.repository.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@RequestMapping("/index")
	public String getIndexPage(Model model){
		
		model.addAttribute("recipes", recipeRepository.findAll());
		return "index";
	}
}