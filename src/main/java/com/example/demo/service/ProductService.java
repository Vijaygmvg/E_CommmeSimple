package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.request.ProductRequest;

@Service 
public interface ProductService {

	Product addProduct(ProductRequest productRequest);

	Product getProduct(String productName);

	boolean deleteProduct(String productName);

}
