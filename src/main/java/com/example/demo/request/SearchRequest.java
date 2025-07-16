package com.example.demo.request;

import lombok.Data;

@Data
public class SearchRequest {

	
	private String productName;
	
	private String CategoryName;
	
	private String CompanyName;
	
	private String Color;
	
	private Long minPrice;
	
	private Long maxPrice;
}
