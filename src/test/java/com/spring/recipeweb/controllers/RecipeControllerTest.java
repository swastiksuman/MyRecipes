package com.spring.recipeweb.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.recipeweb.domain.Recipe;
import com.spring.recipeweb.services.RecipeService;

public class RecipeControllerTest {
	
	@Mock
	RecipeService recipeService;
	
	RecipeController controller;
	
	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		controller = new RecipeController(recipeService);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new ControllerExceptionHandler())
                .build();
	}
	
	@Test
	public void testGetRecipe() throws Exception{
		Recipe recipe = new Recipe();
        recipe.setId(1L);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(recipeService.findById(anyLong())).thenReturn(recipe);
        mockMvc.perform(get("/recipe/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
	}
}
