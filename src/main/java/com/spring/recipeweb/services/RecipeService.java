package com.spring.recipeweb.services;

import java.util.Set;

import com.spring.recipeweb.domain.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipes();
}
