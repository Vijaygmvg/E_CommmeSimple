package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.request.CategoryRequest;

@Service
public interface CategoryService {

	public boolean addCategory(CategoryRequest categoryRequest);

	
	public Category getCategory(String categoryName);


	public boolean deleteCategory(String categoryName);


	public List<Category> getCategories();

}
