package com.emre.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv= new ModelAndView("error");
		
		mv.addObject("errorTitle","This page is not constructed");
		mv.addObject("errorDescription","The page is not available now :(");
		mv.addObject("title","404 ERROR PAGE");
		
		return mv;
		
	}
	

	@ExceptionHandler(Exception.class)
	public ModelAndView handleProductNotFoundException(Exception ex)
	{
		ModelAndView mv= new ModelAndView("error");
			
		mv.addObject("errorTitle","ERROR!");
		
		StringWriter sw= new StringWriter();
		PrintWriter pw= new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","ERROR");
		
		return mv;
		
	}
}
