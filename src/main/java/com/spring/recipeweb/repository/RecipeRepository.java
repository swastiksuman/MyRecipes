package com.spring.recipeweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.recipeweb.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	
}
