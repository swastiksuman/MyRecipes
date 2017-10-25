package com.spring.recipeweb.services;

import com.spring.recipeweb.commands.IngredientCommand;

public interface IngredientService {

	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId,
			Long ingredientId);

	IngredientCommand saveIngredientCommand(IngredientCommand command);

	void deleteById(Long recipeId, Long idToDelete);

}
