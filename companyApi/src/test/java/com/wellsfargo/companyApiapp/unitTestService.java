package com.wellsfargo.companyApiapp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.companyModel.company;
import com.wellsfargo.companyService.companyService;


@RunWith(SpringRunner.class)
public class unitTestService {



	private static final Object Null = null;


	@Test
	public void testGetAllCompanies() throws Exception
	{
		companyService companiesService=new companyService();
		List<company> res=companiesService.getAllCompanies();
		
		assertThat(res.size()>0);
			
	}
	
	@Test
	public void testGetCompanywhenSetCompany() throws Exception
	{
		companyService companiesService=new companyService();
		company reliance = new company();
        reliance.setStockCode(209189);
        reliance.setCeo("Ambani");
        reliance.setBoardOfDirectors("BOARD-A,B,C");
        reliance.setCompanyDetails("A1 company");
        reliance.setCompanyName("RELIANCE");
        reliance.setListedInStockExchanges("NSE");
        reliance.setTurnover(20000000);
        reliance.setSector("telecom");
		
		company saved=companiesService.saveCompany(reliance);
		
		Optional<company> getcompany=companiesService.getCompany(209189);
		assertThat(getcompany).isEqualTo(saved);
			
	}
	@Test
	public void testUpdateCompany() throws Exception
	{
		companyService companiesService=new companyService();
		company reliance = new company();
        reliance.setStockCode(209189);
        reliance.setCeo("Ambani");
        reliance.setBoardOfDirectors("BOARD-A,B,C");
        reliance.setCompanyDetails("A1 company");
        reliance.setCompanyName("RELIANCE");
        reliance.setListedInStockExchanges("BSE");
        reliance.setTurnover(20000000);
        reliance.setSector("telecom");
		company updatedCompany=companiesService.updateCompany(reliance);
		Optional<company> getcompany=companiesService.getCompany(reliance.getStockCode());
		
		assertThat(getcompany).isEqualTo(updatedCompany);
	}
	
	
	@Test
	public void deleteCompany()throws Exception
	{
		companyService companiesService=new companyService();
		company reliance2 = new company();
        reliance2.setStockCode(2091892);
        reliance2.setCeo("Ambani");
        reliance2.setBoardOfDirectors("BOARD-A,B,C");
        reliance2.setCompanyDetails("A1 company");
        reliance2.setCompanyName("RELIANCE2");
        reliance2.setListedInStockExchanges("BSE");
        reliance2.setTurnover(200000001);
        reliance2.setSector("telecom");
        companiesService.deleteCompany(reliance2.getStockCode());
        Optional<company> isdeleted=companiesService.getCompany(2091892);
        
        assertThat(isdeleted).isEqualTo(Null);
	}
}

