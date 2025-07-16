package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.request.SearchRequest;

@Service
public interface SearchService {
	
	List<Product> getProducts(SearchRequest searchRequest);

}
