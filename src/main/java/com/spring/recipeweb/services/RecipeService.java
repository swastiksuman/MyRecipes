package com.spring.recipeweb.services;

import java.util.Set;

import com.spring.recipeweb.commands.RecipeCommand;
import com.spring.recipeweb.domain.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipes();

	Recipe findById(Long long1);

	RecipeCommand saveRecipeCommand(RecipeCommand command);
}
