package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Company;
import com.example.demo.request.CompanyRequest;

@Service
public interface CompanyService {

	boolean addCompany(CompanyRequest companyRequest);

	Company getCompany(String companyName);

	boolean deleteCompany(String companyName);

	List<Company> getCompanies();

}
