package com.emre.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emre.shoppingbackend.dao.CategoryDAO;
import com.emre.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	

	public List<Category> list() {
		
		String selectActiveCategory= "FROM Category WHERE isActive = :isActive";
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("isActive", true);
		
		return query.getResultList();
	}
	
	public Category get(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	
	@Transactional
	public boolean add(Category category) {

			try {
					sessionFactory.getCurrentSession().persist(category);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
	}
			
	}

	public boolean update(Category category) {

		try {
				sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
}
	}

	public boolean delete(Category category) {
		
		
		category.setActive(false);

		try {
				sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
}
	}

}
