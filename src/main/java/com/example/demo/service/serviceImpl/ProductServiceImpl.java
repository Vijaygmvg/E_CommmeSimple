package com.example.demo.service.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Company;
import com.example.demo.entity.Product;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.request.ProductRequest;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CompanyService;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

	
	private final ProductRepository productRepository;
	private final CompanyService compnayService;
	private final CategoryService categoryService;
	
	
	@Override
	public Product addProduct(ProductRequest productRequest) {
		
		Optional<Product> product=productRepository.findByProductName(productRequest.getProductName());
		if(product.isPresent())
		{
			throw new AlreadyExistException("this product name ius already existes you ad the availabe details");
			
		}
		try {
			Category category=categoryService.getCategory(productRequest.getCategoryName());
			Company compnay=compnayService.getCompany(productRequest.getCompanyName());
			Product savedProduct=new Product();
			savedProduct.setProductName(productRequest.getProductName());
			savedProduct.setPrice(productRequest.getPrice());
			savedProduct.setColor(productRequest.getColor());
			savedProduct.setCategory(category);
			savedProduct.setCompany(compnay);
			savedProduct=productRepository.save(savedProduct);
			return savedProduct;
			
		}
		catch(Exception e) {
			
			throw e;
		}
	 
	}

	@Override
	public Product getProduct(String productName) {
		
		Optional<Product> product=productRepository.findByProductName(productName);
		if(product.isPresent())
			return product.get();
		throw new NotFoundException("the given name product is not available ");
		
		
	}

	@Override
	public boolean deleteProduct(String productName) {
	 
		Product product=productRepository.findByProductName(productName).get();
		if(product==null)
		throw new NotFoundException("the given product us not availabe ");
		
		productRepository.deleteById(product.getProductId());
		return true;
	}

}
