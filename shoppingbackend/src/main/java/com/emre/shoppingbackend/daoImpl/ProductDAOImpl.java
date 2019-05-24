package com.emre.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emre.shoppingbackend.dao.ProductDAO;
import com.emre.shoppingbackend.dto.Product;



@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;


	public Product get(int productId) {
		try {
			return	sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
		 
	} catch (Exception e) {
		e.printStackTrace();
		
	}
		return null;
	}

	public List<Product> list() {
		String selectActiveProduct= "FROM Product WHERE isActive = :isActive";
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		query.setParameter("isActive", true);
		
		return query.getResultList();
	}

	public boolean add(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
