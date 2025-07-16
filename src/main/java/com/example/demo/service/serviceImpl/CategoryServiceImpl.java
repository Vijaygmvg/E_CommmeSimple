package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.request.CategoryRequest;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl  implements CategoryService{
	
	private final CategoryRepository categoryRepository;

	@Override
	public boolean addCategory(CategoryRequest categoryRequest) {
		
		
		Optional<Category> categoryOpt=categoryRepository.findByCategoryName(categoryRequest.getName());
		if(categoryOpt.isPresent()) {
			throw new AlreadyExistException("the given category is already existed ");
		}
		
	    Category category=new Category(categoryRequest.getName());
		category=categoryRepository.save(category);
		return category!=null;
	}

	@Override
	public Category getCategory(String  categoryName) {
	
	     Optional<Category> category=categoryRepository.findByCategoryName(categoryName);
	     if(category.isPresent()) return category.get();
	      throw new NotFoundException("this is the invalid category name not found ");
	}

	@Override
	public boolean deleteCategory(String categoryName) {

       Optional<Category> category=categoryRepository.findByCategoryName(categoryName);
       if(!category.isPresent()) {
		throw new NotFoundException("this is the invalid category name not found ");
	}
       categoryRepository.deleteById(category.get().getCategoryId());
       return true;
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	

}
