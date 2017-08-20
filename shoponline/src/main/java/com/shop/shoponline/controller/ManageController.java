package com.shop.shoponline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.shoponline.util.FileUploadUtil;
import com.shop.shoponline.validators.ProductValidator;
import com.shop.shoponlinebackend.dao.CategoryDAO;
import com.shop.shoponlinebackend.dao.ProductDAO;
import com.shop.shoponlinebackend.dto.Category;
import com.shop.shoponlinebackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManageController {

	@Autowired
	CategoryDAO categoryDAO;
	
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView manageProducts(@RequestParam(name="operation", required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Products");
		mv.addObject("clickManageProducts", true);
		Product product = new Product();
		product.setSupplierId(1);
		product.setActive(true);
		
		mv.addObject("product",product);
		if("product".equals(operation))
			mv.addObject("message", "Product Submitted successfully");
		return mv;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String manageProductSubmit(@Valid @ModelAttribute("product") Product product, BindingResult results, Model model, HttpServletRequest request)
	{
		
		new ProductValidator().validate(product, results);
		if(results.hasErrors())
		{
			model.addAttribute("title", "Manage Products");
			model.addAttribute("clickManageProducts", true);
			model.addAttribute("message","validation failed!!");
			
			return "page";
		}
		
		productDAO.addProduct(product);
		
		if(!product.getFile().getOriginalFilename().equals(""))
		{
			
			FileUploadUtil.uploadFile(request, product.getFile(), product.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.listCategory();
	}
}
