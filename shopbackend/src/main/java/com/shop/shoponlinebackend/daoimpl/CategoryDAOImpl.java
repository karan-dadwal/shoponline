package com.shop.shoponlinebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.shoponlinebackend.dao.CategoryDAO;
import com.shop.shoponlinebackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> list = new ArrayList<Category>();
	static {
		Category cat = new Category();
		cat.setId(1);
		cat.setName("Fashion");
		cat.setDescription("fashion and accessories");
		cat.setImageUrl("abc.png");
		list.add(cat);
		cat = new Category();
		cat.setId(2);
		cat.setName("Electronics");
		cat.setDescription("mobiles, tv");
		cat.setImageUrl("abc2.png");
		list.add(cat);
	}

	public List<Category> listCategory() {
		// TODO Auto-generated method stub

		return list;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub

		for (Category category : list) {
			if (category.getId() == id)
				return category;
		}
		return null;
	}

}
