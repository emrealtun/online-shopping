package com.emre.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.emre.onlineshopping.exception.ProductNotFoundException;
import com.emre.shoppingbackend.dao.CategoryDAO;
import com.emre.shoppingbackend.dao.ProductDAO;
import com.emre.shoppingbackend.dto.Category;
import com.emre.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger= LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value = { "/", "/index", "/home"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		
		logger.info("Inside PageController - INFO");
		logger.debug("Inside PageController - DEBUG");
		
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		
		return mv;
	}
	
	
	/**
	 *Load all product and based on category methods
	 * 
	 */

	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProduct()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("userClickAllProduct",true);
		mv.addObject("categories",categoryDAO.list());
		
		return mv;
	}
	 
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		Category category= null;
		category= categoryDAO.get(id);
		mv.addObject("title",category.getName());
		mv.addObject("category",category);
		mv.addObject("title","Products");
		mv.addObject("userClickCategoryProduct",true);
		mv.addObject("categories",categoryDAO.list());
		
		return mv;
	}
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value="show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException
	{
		ModelAndView mv= new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product==null)
			throw new ProductNotFoundException();
		
		//update the view count
		product.setViews(product.getViews()+1);
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		
		
		return mv;
	}
	
	

}
