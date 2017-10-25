package com.spring.recipeweb.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.spring.recipeweb.domain.Recipe;
import com.spring.recipeweb.repository.RecipeRepository;

public class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		//recipeService=new RecipeServiceImpl(recipeRepository);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public final void testGetRecipes() {
		
		//given
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipeData = new HashSet<Recipe>();
		recipeData.add(recipe);
		recipeData.add(new Recipe());
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		when(recipeService.getRecipes()).thenReturn(recipeData);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		assertEquals(2, recipes.size());
		verify(recipeRepository, times(1)).findAll();
		//verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
	}
	
	
}
