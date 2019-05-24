package com.emre.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.emre.shoppingbackend.dao.CategoryDAO;
import com.emre.shoppingbackend.dto.Category;

public class CategoryTestCase {

		private static AnnotationConfigApplicationContext context;
		private static CategoryDAO categoryDAO;	
		private  Category  category; 

		@BeforeClass
		public static void init()
		{
			context= new AnnotationConfigApplicationContext();
			context.scan("com.emre.shoppingbackend");
			context.refresh();
			
			categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		}
		
	
		@Test
		public void testAddCategory()
		{
		category = new Category();
		
		category.setName("Mobile");
		category.setDescription("Mobile");
		category.setImageURL("item.png");
		category.setActive(true);
			
	
		assertEquals("Successsull add category",true, categoryDAO.add(category));

		}
		

		/*@Test
		public void testListCategory()
		{
		
			assertEquals("Successfully get list of categories",3,categoryDAO.list().size());
			
		}
		*/
		
}


