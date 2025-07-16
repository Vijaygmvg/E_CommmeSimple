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
import com.example.demo.entity.Company;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.request.CompanyRequest;
import com.example.demo.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
private  final CompanyService companyService;
	
@PostMapping("/add")
	public ResponseEntity<?> addCompany(@RequestBody CompanyRequest companyRequest){
		
		try {
		boolean addCompany=companyService.addCompany(companyRequest);
		return new ResponseEntity(true, HttpStatus.OK);
		}
		catch(AlreadyExistException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
@GetMapping("/get")
public ResponseEntity<?> getCompany(@RequestParam("companyName")String companyName ){
		
		try {
		Company company=companyService.getCompany(companyName);
		return new ResponseEntity(company, HttpStatus.OK);
		}
		catch(NotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}

@DeleteMapping("/delete/{companyName}")

public ResponseEntity<?> deleteCompany(@PathVariable String companyName){
	
	try {
		boolean success=companyService.deleteCompany(companyName);
	    return new ResponseEntity(true,HttpStatus.OK);
	}
	catch(NotFoundException e) {
		
		
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}

@GetMapping("/get/all")
public ResponseEntity<?> getAllCategory(){
	try {
	List<Company> companies=companyService.getCompanies();
	return new ResponseEntity(companies, HttpStatus.OK);
	}
	catch(NotFoundException e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}



}
