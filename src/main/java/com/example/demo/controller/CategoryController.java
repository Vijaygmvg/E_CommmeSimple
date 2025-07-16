package com.example.demo.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.request.CategoryRequest;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
	
	private  final CategoryService categoryService;
	
    @PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody CategoryRequest categoryRequest){
		
		try {
		boolean addCategory=categoryService.addCategory(categoryRequest);
		return new ResponseEntity(true, HttpStatus.OK);
		}
		catch(AlreadyExistException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
    @GetMapping("/get")
public ResponseEntity<?> getCategory(@RequestParam("categoryName")String categoryName ){
		
		try {
		Category category=categoryService.getCategory(categoryName);
		return new ResponseEntity(category, HttpStatus.OK);
		}
		catch(NotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}

@DeleteMapping("/delete/{categoryName}")

public ResponseEntity<?> deleteCategory(@PathVariable String categoryName){
	
	try {
		boolean success=categoryService.deleteCategory(categoryName);
	    return new ResponseEntity(true,HttpStatus.OK);
	}
	catch(NotFoundException e) {
		
		
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
	

    @GetMapping("/get/all")
     public ResponseEntity<?> getAllCategory(){
		try {
		List<Category> categoris=categoryService.getCategories();
		return new ResponseEntity(categoris, HttpStatus.OK);
		}
		catch(NotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}




	
}
