package com.emre.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	
	@RequestMapping(value = { "/", "/index", "/home"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to Spring web Mvc");
		return mv;
	}
	
	@RequestMapping(value ="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String  greeting)
	{
		if(greeting==null)
		{
			greeting ="Hello world";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}


}
