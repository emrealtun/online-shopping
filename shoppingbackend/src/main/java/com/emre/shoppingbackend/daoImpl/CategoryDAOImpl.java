package com.emre.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emre.shoppingbackend.dao.CategoryDAO;
import com.emre.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private  static List<Category> categories = new ArrayList<Category>();
	
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Television Description");
		category.setImageURL("cat1.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Mobile Description");
		category.setImageURL("cat2.png");
		
		categories.add(category);
		
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Laptop Description");
		category.setImageURL("cat1.png");
		
		categories.add(category);
	}
	
	public List<Category> list() {

		return categories;
	}
	
	public Category get(int id) {
		
		for(Category category : categories)
		{
			if(category.getId()== id)
				{
					return category;
				}
		}
		
		
		return null;
	}

}
