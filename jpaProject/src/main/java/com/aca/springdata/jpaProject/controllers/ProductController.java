package com.aca.springdata.jpaProject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aca.springdata.jpaProject.entities.Products;
import com.aca.springdata.jpaProject.repos.ProductsRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	private ProductsRepository repository;
	
	public ProductController(ProductsRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/products")
	public List<Products> getProducts(){
		return repository.findAll();
	}
	
	@GetMapping("/products/price/{price}")
	public List<Products> getProductByPrice(@PathVariable("price") Double price) {
		return repository.findByPRICE(price);
	}
	
	@GetMapping("/products/name/{name}")
	public Products getProductByName(@PathVariable("name") String name) {
		return repository.findByNAME(name).get(0);
	}
	
	@PostMapping("/products")
	public Products saveProduct(@RequestBody Products product) {
		List<Products> names = repository.findByNAME(product.getNAME());
		if (names.isEmpty()) {
			return repository.save(product);
		}else {
			Products product2 = repository.findByNAME(product.getNAME()).get(0);
			product2.setTOTAL_PRODUCTS_INVENTORY(product.getTOTAL_PRODUCTS_INVENTORY() + 1);
			return repository.save(product2);
		}
	}
	
	@PatchMapping("/products/{id}/{price}/{img}/{desc}/{total}")
	public Products updateProduct(@PathVariable("id") long id,
			@PathVariable("price") Double price,
			@PathVariable("img") byte[] img,
			@PathVariable("desc") String desc,
			@PathVariable("total") long total) {
		Products product = repository.findById(id).get();
		product.setPRICE(price);
		product.setIMAGE(img);
		product.setDESCRIPTION(desc);
		product.setTOTAL_PRODUCTS_INVENTORY(total);
		return repository.save(product);
	}
	
	@PatchMapping("/products/{name}")
	public Products deleteProduct(@PathVariable String name) {
		Products product = repository.findByNAME(name).get(0);
		product.setSTATUS(false);
		return repository.save(product);
	}
}
