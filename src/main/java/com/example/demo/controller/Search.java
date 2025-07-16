package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.request.SearchRequest;
import com.example.demo.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class Search {

	
	
	private final SearchService searchService;
	@PostMapping("/products")
	public ResponseEntity<List<Product>> getProducts(SearchRequest searchRequest){
		try {
		List<Product> products=searchService.getProducts(searchRequest);
		return new ResponseEntity(products,HttpStatus.OK);
		}
		catch(Exception e ) {
			
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
		
	}
	  
}
