package com.shop.shoponline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.shoponline.exception.ProductNotFoundException;
import com.shop.shoponlinebackend.dao.CategoryDAO;
import com.shop.shoponlinebackend.dao.ProductDAO;
import com.shop.shoponlinebackend.dto.Category;
import com.shop.shoponlinebackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping(value ={"/","/home", "/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
	
		logger.info("Inside home controller");
		
		mv.addObject("listCategory", categoryDAO.listCategory());
		mv.addObject("clickHome", true);
		return mv;
	}

	
	@RequestMapping(value ="/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("clickAbout", true);
		return mv;
	}

	
	@RequestMapping(value ="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("clickContact", true);
		return mv;
	}

	/*@RequestMapping(value ={"/test"})
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	*/
	/*@RequestMapping(value ={"/test/{greeting}"})
	public ModelAndView test(@PathVariable(value="greeting", required=false)String greeting)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
	

	@RequestMapping(value ="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("listCategory", categoryDAO.listCategory());
		mv.addObject("clickAllProducts", true);
		return mv;
	}
	
	

	@RequestMapping(value ="show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		Category category = categoryDAO.getCategoryById(id);
		mv.addObject("title", category.getName());
		mv.addObject("listCategory", categoryDAO.listCategory());
		mv.addObject("category", category);
		mv.addObject("clickCategoryProducts", true);
		return mv;
	}

	// show product by id
	@RequestMapping(value ="/show/{id}/product")
	public ModelAndView showProduct(@PathVariable("id") int id) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.getProduct(id);
		
		if(product == null) throw new ProductNotFoundException();
		product.setViews(product.getViews() + 1);
		productDAO.updateProduct(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("clickProduct", true);
		return mv;
	}
	
	
	
	
	
	
}
