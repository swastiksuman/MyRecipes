package com.spring.recipeweb.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	Category category;
	
	@Before
	public void setUp(){
		category = new Category();
	}
	
	@Test
	public void getId(){
		Long idVal=1L;
		category.setId(idVal);
		assertEquals(idVal, category.getId());
	}
	
	@Test
	public void getDescription(){
		
	}
	
	@Test
	public void getRecipes(){
		
	}
	
}
