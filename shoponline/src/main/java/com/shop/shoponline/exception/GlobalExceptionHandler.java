package com.shop.shoponline.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Page not found");
		mv.addObject("errorDesc", "Page you are looking for is not found");
		mv.addObject("title", "404 error");
		
		return mv;
		
		
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product Not Found");
		mv.addObject("errorDesc", "Product you are looking for is not found!!");
		mv.addObject("title", "Product Not Found");
		
		return mv;
		
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv = new ModelAndView("error");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		mv.addObject("errorTitle", "Something went wrong!");
		mv.addObject("errorDesc", sw.toString());
		mv.addObject("title", "Error!!");
		
		return mv;
		
		
	}

}
