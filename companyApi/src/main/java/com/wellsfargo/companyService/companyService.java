package com.wellsfargo.companyService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wellsfargo.companyModel.company;
import com.wellsfargo.repository.companyRepo;

@Service
public class companyService {


	@Autowired
	private companyRepo companyRepo;
	

	public List<company> getAllCompanies()
	{
		List<company> allCompanies=companyRepo.findAll();
		return allCompanies;
	}
	
	
	public Optional<company> getCompany(long stockCode)
	{
		Optional<company> companyres=companyRepo.findById(stockCode);
		return companyres;
	}
	
	
	public company saveCompany(company C)
	{
		companyRepo.save(C);
		return C;
	}
	
	
	
	public company updateCompany(company C)
	{
		company comp=companyRepo.save(C);
		return comp;
	}
	
	
	public void deleteCompany(long stockCode)
	{
		companyRepo.deleteById(stockCode);
		
	}
	
}


