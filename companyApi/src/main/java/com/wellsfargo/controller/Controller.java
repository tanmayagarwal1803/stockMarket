package com.wellsfargo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.companyModel.company;
import com.wellsfargo.companyService.companyService;
//import org.springframework.context.ApplicationContext;



@RestController
@CrossOrigin(origins="http://localhost:3000")
public class Controller {
	
	@Autowired
	private companyService companyService;
	
	@RequestMapping("/")
	public String home()
	{
		return "Hello";
		
	}
	
	@GetMapping("/company/all")
	public List<company> getAllCompany()
	{
		List<company> getCompanies=companyService.getAllCompanies();
		return getCompanies;
	}
	
	
	@GetMapping("/company/{stockCode}")
	public Optional<company> getOneCompany(@PathVariable long stockCode)
	
	{
		Optional<company> getCompany=companyService.getCompany(stockCode);
		return getCompany;
	}
	
	
	@PostMapping("/companies")
		public company saveCompany(@RequestBody company company)
																			
		{
			company companyres=companyService.saveCompany(company);
			return companyres;
		}
		
		
	@PutMapping("/companies")
		public company updateCompany(@RequestBody company comp)
		{
		 	company compres=companyService.updateCompany(comp);
		return compres;
		}
		
	@DeleteMapping("/companies/{stockCode}")
		public String deleteCompany(@PathVariable long stockCode)
		{
		Optional<company> comp=companyService.getCompany(stockCode);
		if(comp!=null)
		{
			companyService.deleteCompany(stockCode);
			return "Company deleted";
		}
		else
			return "Company doesnt exist";
			
		}
}


