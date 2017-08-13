package com.shop.shoponlinebackend.dao;


import java.util.List;

import com.shop.shoponlinebackend.dto.Category;

public interface CategoryDAO {

	List<Category> listCategory();
	Category getCategoryById(int id);
	Boolean addCategory(Category category);
	Boolean updateCategory(Category category);
	Boolean deleteCategory(Category category);
	
}
