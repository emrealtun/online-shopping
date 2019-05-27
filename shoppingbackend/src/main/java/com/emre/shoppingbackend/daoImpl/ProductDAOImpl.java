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
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
		
	}

	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return false;
	}

	public boolean update(Product product) {
		try {
			 sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return false;
	}

	public boolean delete(Product product) {
			
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public List<Product> listActiveProducts() {
		
		String selectActiveProduct = "FROM Product WHERE  isActive= :isActive";
		
		return sessionFactory.getCurrentSession().createQuery(selectActiveProduct,Product.class).setParameter("isActive",true).getResultList();
	}

	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String selectActiveProductsByCategory= "FROM Product WHERE isActive= :isActive  AND categoryId= :categoryId";
		
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("isActive", true).setParameter("categoryId",categoryId).getResultList();
		}

	public List<Product> getLatestActiveProducts(int count) {
		
		String selectLastestActiveProducts= "FROM Product WHERE isActive= :isActive ORDER BY id";
		
		return sessionFactory.getCurrentSession().createQuery(selectLastestActiveProducts,Product.class)
				.setParameter("isActive", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
