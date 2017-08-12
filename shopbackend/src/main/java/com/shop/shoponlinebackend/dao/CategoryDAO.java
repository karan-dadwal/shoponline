package com.shop.shoponlinebackend.dao;


import java.util.List;

import com.shop.shoponlinebackend.dto.Category;

public interface CategoryDAO {

	
	List<Category> listCategory();
	Category getCategoryById(int id);
}
