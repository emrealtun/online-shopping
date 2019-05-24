package com.emre.shoppingbackend.dao;

import java.util.List;

import com.emre.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
	boolean  add(Category category);
	boolean  update(Category category);
	boolean  delete(Category category);


}
