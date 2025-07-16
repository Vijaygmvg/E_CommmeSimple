package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Company;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.request.CompanyRequest;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl  implements CompanyService{
	
	private final CompanyRepository CompanyRepository;

	@Override
	public boolean addCompany(CompanyRequest CompanyRequest) {
		
		
		Optional<Company> CompanyOpt=CompanyRepository.findByName(CompanyRequest.getName());
		if(CompanyOpt.isPresent()) {
			throw new AlreadyExistException("the given Company is already existed ");
		}
		
	    Company Company=new Company(CompanyRequest.getName());
		Company=CompanyRepository.save(Company);
		return Company!=null;
	}

	@Override
	public Company getCompany(String  CompanyName) {
	
	     Optional<Company> Company=CompanyRepository.findByName(CompanyName);
	     if(Company.isPresent()) return Company.get();
	      throw new NotFoundException("this is the invalid Company name not found ");
	}

	@Override
	public boolean deleteCompany(String CompanyName) {

       Optional<Company> Company=CompanyRepository.findByName(CompanyName);
       if(!Company.isPresent()) {
		throw new NotFoundException("this is the invalid Company name not found ");
	}
       CompanyRepository.deleteById(Company.get().getCompanyId());
       return true;
	}

	@Override
	public List<Company> getCompanies() {
		return CompanyRepository.findAll();	}
	
	

}
