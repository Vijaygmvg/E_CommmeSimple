package com.example.demo.entity;

import org.springframework.context.annotation.Lazy;

import com.example.demo.request.ProductRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	
	private String productName;
	
	private Long price;
	
	
	private String color;
	
	@ManyToOne
	@JoinColumn(name="company")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="category")
	private Category category;
	
	

}
