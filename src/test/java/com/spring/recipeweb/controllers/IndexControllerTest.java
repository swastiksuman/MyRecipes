package com.spring.recipeweb.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.spring.recipeweb.services.RecipeService;

public class IndexControllerTest {
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController indexController;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController();
	}

	@Test
	public final void test() {
		//when(indexController.getIndexPage(model)).thenReturn(recipeData);
		assertEquals("index", indexController.getIndexPage(model));
	}

}
