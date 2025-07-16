package com.example.demo.controller;

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

import com.example.demo.entity.Product;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.request.ProductRequest;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Product")
@RequiredArgsConstructor
public class ProductController {
	
private final ProductService productService;
	
@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest){
		
		try {
		Product addProduct=productService.addProduct(productRequest);
		return new ResponseEntity(addProduct, HttpStatus.OK);
		}
		catch(AlreadyExistException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
@GetMapping("/get")
public ResponseEntity<?> getProduct(@RequestParam("productName")String productName ){
		
		try {
		Product product=productService.getProduct(productName);
		return new ResponseEntity(product, HttpStatus.OK);
		}
		catch(NotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}

@DeleteMapping("/delete/{productName}")

public ResponseEntity<?> deleteProduct(@PathVariable String productName){
	
	try {
		boolean success=productService.deleteProduct(productName);
	    return new ResponseEntity(true,HttpStatus.OK);
	}
	catch(NotFoundException e) {
		
		
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}



}
