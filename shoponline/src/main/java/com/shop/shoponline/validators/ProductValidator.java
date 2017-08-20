package com.shop.shoponline.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shop.shoponlinebackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if (product.getFile().getOriginalFilename().equals("") || product.getFile() == null) {
			errors.rejectValue("file", null, "No file specified!");
		}

		else if (!(product.getFile().getContentType().equals("image/jpeg")
				|| product.getFile().getContentType().equals("image/png"))) {

			errors.rejectValue("file", null, "Not a valid file");
		}

	}

}
