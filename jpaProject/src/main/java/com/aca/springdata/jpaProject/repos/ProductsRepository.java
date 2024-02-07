package com.aca.springdata.jpaProject.repos;

import org.springframework.data.repository.CrudRepository;

import com.aca.springdata.jpaProject.entities.Products;
import java.util.List;


public interface ProductsRepository extends CrudRepository<Products, Long> {

	List<Products> findByNAME(String nAME);
	
	List<Products> findByPRICE(Double pRICE);
	
}
