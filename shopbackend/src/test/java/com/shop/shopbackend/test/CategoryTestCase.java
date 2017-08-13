package com.shop.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.shoponlinebackend.dao.CategoryDAO;
import com.shop.shoponlinebackend.dto.Category;

public class CategoryTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop.shoponlinebackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	/*
	@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("TV");
		category.setDescription("this is tv");
		category.setImageUrl("abc.png");
		
		assertEquals("Successfully added category", true, categoryDAO.addCategory(category));
		
		
	}*/
	
	/*@Test
	public void testListCategory()
	{
		
		assertEquals("Successfully tested listCategory", 1, categoryDAO.listCategory().size());
		
		
	}*/
	
/*	@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.getCategoryById(1);
		category.setName("Television");
		assertEquals("Successfully added category", true, categoryDAO.updateCategory(category));
		
		
	}
*/	@Test
	public void testDeleteCategory()
	{
		category = categoryDAO.getCategoryById(1);
		
		assertEquals("Successfully added category", true, categoryDAO.deleteCategory(category));
		
		
	}
	
}
