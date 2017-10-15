package com.spring.recipeweb.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.spring.recipeweb.domain.Recipe;
import com.spring.recipeweb.services.RecipeServiceImpl;

public class IndexControllerTest {

	@Mock
	RecipeServiceImpl recipeService;

	@Mock
	Model model;

	IndexController indexController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController)
				.build();

		mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(view().name("index"));
	}

	@Test
	public final void test() {
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipeData = new HashSet<Recipe>();
		recipeData.add(recipe);

		when(recipeService.getRecipes()).thenReturn(recipeData);
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor
				.forClass(Set.class);
		assertEquals("index", indexController.getIndexPage(model));
	}

}
