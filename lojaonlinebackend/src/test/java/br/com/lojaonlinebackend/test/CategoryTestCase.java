package br.com.lojaonlinebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.lojaonlinebackend.dao.CategoryDAO;
import br.com.lojaonlinebackend.dto.Category;

public class CategoryTestCase {


	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.lojaonlinebackend");
		context.refresh();
	
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		
		category.setName("LapTop");
		category.setDescription("This is some desciption for Laptop");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfuly added a category inside the table", true, categoryDAO.add(category));
	}
	
/*
	
	@Test
	public void testGetCategory() {

		category = categoryDAO.get(1);
		
		assertEquals("Successfuly added a category inside the table", "TV", category.getName());
	}
	
	

	@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(1);
		
		category.setActive(true);
		

		assertEquals("Successfuly updated a category inside the table", true, categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(1);		

		assertEquals("Successfuly deleted a category from the table", true, categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testLisCategory() {

		assertEquals("Successfuly fetched the list of category from the table", 2, categoryDAO.list().size());
	}*/
}
