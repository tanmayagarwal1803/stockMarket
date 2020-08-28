package com.wellsfargo.companyModel;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

//import lombok.Data;

@Entity
@Table(name="company")
public class company{

	@Id
	private long stockCode;
	
	

	@Column
	private String companyName;
	
	@Column
	private long turnover;
	
	@Column
	private String ceo;
	
	@Column
	private String boardOfDirectors;
	
	@Column
	private String listedInStockExchanges;
	
	@Column
	private String Sector;
	
	@Column
	private String companyDetails;
	
	
	
	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public long getTurnover() {
		return turnover;
	}



	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}



	public String getCeo() {
		return ceo;
	}



	public void setCeo(String ceo) {
		this.ceo = ceo;
	}



	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}



	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}



	public String getListedInStockExchanges() {
		return listedInStockExchanges;
	}



	public void setListedInStockExchanges(String listedInStockExchanges) {
		this.listedInStockExchanges = listedInStockExchanges;
	}



	public String getSector() {
		return Sector;
	}



	public void setSector(String sector) {
		Sector = sector;
	}



	public String getCompanyDetails() {
		return companyDetails;
	}



	public void setCompanyDetails(String companyDetails) {
		this.companyDetails = companyDetails;
	}



	public long getStockCode() {
		return stockCode;
	}



	public void setStockCode(long stockCode) {
		this.stockCode = stockCode;
	}

}

