package com.spring.recipeweb.controllers;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spring.recipeweb.commands.RecipeCommand;
import com.spring.recipeweb.exceptions.NotFoundException;
import com.spring.recipeweb.services.RecipeService;

@Slf4j
@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/recipe/{id}/show")
	public String showById(@PathVariable String id, Model model) {
		System.out.println("Inside Recipe Controller");

		model.addAttribute("recipe", recipeService.findById(new Long(id)));

		return "recipe/show";
	}

	@GetMapping("recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());
		
		return "recipe/recipeform";
	}

	@GetMapping("/recipe/{id}/update")
	public String updateById(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(new Long(id)));
		return "recipe/recipeform";
	}

	@GetMapping("/recipe/{id}/delete")
	public String deleteById(@PathVariable String id, Model model) {
		System.out.println("ID:" + id);
		recipeService.deleteById(Long.valueOf(id));
		return "redirect:/index";
	}

	@PostMapping("recipe")
	public String saveOrUpdate(@Valid @ModelAttribute RecipeCommand command, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			
            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });    
            return "recipe/recipeform";
        }

		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
		return "redirect:/recipe/" + savedCommand.getId() + "/show";
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleNotFound(Exception exception) {
		log.error("Handling not found exception");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("404error");
		return modelAndView;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView formatException(Exception exception) {
		log.error("Handling not found exception");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("400error");
		return modelAndView;
	}
}
