package com.spring.recipeweb.services;

import java.util.Set;

import com.spring.recipeweb.commands.RecipeCommand;
import com.spring.recipeweb.domain.Recipe;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}