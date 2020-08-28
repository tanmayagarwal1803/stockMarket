package com.wellsfargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wellsfargo.companyModel.companyModel;



@Repository
public interface companyRepo extends JpaRepository<company,Long>
{
	

}
