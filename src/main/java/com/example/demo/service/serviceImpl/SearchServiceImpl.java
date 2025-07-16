package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.request.SearchRequest;
import com.example.demo.service.SearchService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {
	
	private final ProductRepository productRepository;

	@Override
	public List<Product> getProducts(SearchRequest searchRequest) {
		
		    List<Product> products=productRepository.findAll();
		    if(!searchRequest.getProductName().equals("")) {
		    	products=products.stream().filter(a->a.getProductName().contains(searchRequest.getProductName())).toList();
		    }
		    if(!searchRequest.getCompanyName().equals("")) {
		    	products=products.stream().filter(a->a.getCompany().getName().contains(searchRequest.getCompanyName())).toList();
		    }
		    if(!searchRequest.getCategoryName().equals("")) {
		    	products=products.stream().filter(a->a.getCategory().getCategoryName().contains(searchRequest.getCategoryName())).toList();
		    }
		    if(!searchRequest.getColor().equals("")) {
		    	products=products.stream().filter(a->a.getColor().contains(searchRequest.getColor())).toList();
		    }
		    if(searchRequest.getMaxPrice()!=0) {
		    	products=products.stream().filter(a->a.getPrice()<=searchRequest.getMaxPrice()).toList();
		    }
		    if(searchRequest.getMinPrice()!=0) {
		    	products=products.stream().filter(a->a.getPrice()>=searchRequest.getMinPrice()).toList();
		    }
		    
		    
		    return products;
		
	}

}
