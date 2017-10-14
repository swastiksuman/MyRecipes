package com.spring.recipeweb.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.recipeweb.domain.Recipe;
import com.spring.recipeweb.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public Set<Recipe> getRecipes() {
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}
}
