package com.wellsfargo.companyApiapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.companyModel.company;
import com.wellsfargo.controller.Controller;

@RunWith(SpringRunner.class)
public class unitTestController {

	@Test
	public void testGetAllCompanies() throws Exception
	{
		Controller companiesController=new Controller();
		List<company> res=companiesController.getAllCompany();
		
		assertThat(res.size()>0);
			
	}
	
	@Test
	public void testGetCompanywhenSetCompany() throws Exception
	{
		Controller companiesController=new Controller();
		company reliance = new company();
        reliance.setStockCode(209189);
        reliance.setCeo("Ambani");
        reliance.setBoardOfDirectors("BOARD-A,B,C");
        reliance.setCompanyDetails("A1 company");
        reliance.setCompanyName("RELIANCE");
        reliance.setListedInStockExchanges("NSE");
        reliance.setTurnover(20000000);
        reliance.setSector("telecom");
		
		company saved=companiesController.saveCompany(reliance);
		
		Optional<company> getcompany=companiesController.getOneCompany(209189);
		assertThat(getcompany).isEqualTo(saved);
			
	}
	@Test
	public void testUpdateCompany() throws Exception
	{
		Controller companiesController=new Controller();
		company reliance = new company();
        reliance.setStockCode(209189);
        reliance.setCeo("Ambani");
        reliance.setBoardOfDirectors("BOARD-A,B,C");
        reliance.setCompanyDetails("A1 company");
        reliance.setCompanyName("RELIANCE");
        reliance.setListedInStockExchanges("BSE");
        reliance.setTurnover(20000000);
        reliance.setSector("telecom");
		company updatedCompany=companiesController.updateCompany(reliance);
		Optional<company> getcompany=companiesController.getOneCompany(reliance.getStockCode());
		
		assertThat(getcompany).isEqualTo(updatedCompany);
	}
	
	
	@Test
	public void deleteCompany()throws Exception
	{
		Controller companiesController=new Controller();
		company reliance2 = new company();
        reliance2.setStockCode(2091892);
        reliance2.setCeo("Ambani");
        reliance2.setBoardOfDirectors("BOARD-A,B,C");
        reliance2.setCompanyDetails("A1 company");
        reliance2.setCompanyName("RELIANCE2");
        reliance2.setListedInStockExchanges("BSE");
        reliance2.setTurnover(200000001);
        reliance2.setSector("telecom");
        String deleted=companiesController.deleteCompany(reliance2.getStockCode());
        
        assertThat(deleted).isEqualTo("Company doesnt exist");
	}
}
