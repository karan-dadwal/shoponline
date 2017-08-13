package com.shop.shoponlinebackend.dao;

import java.util.List;

import com.shop.shoponlinebackend.dto.Product;

public interface ProductDAO {

	
	Product getProduct(int id);
	List<Product> listProduct();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int catId);
	List<Product> getLatestActiveProducts(int count);
	
}
