package com.emre.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.emre.shoppingbackend.dao.ProductDAO;
import com.emre.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;	
	private  Product product; 

	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.emre.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testProduct()
	{
		product = new Product();
		product.setName("Samsung S10");
		product.setBrand("Samsung");
		product.setDescription("Samsung mobile phone");
		product.setQuantity(100);
		product.setUnitPrice(5000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		product.setPurchases(5); 
		
		assertEquals("Insert new product",true,productDAO.add(product));
		
		
		
		
	}
	
}
