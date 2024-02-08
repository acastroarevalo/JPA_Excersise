package com.aca.springdata.jpaProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aca.springdata.jpaProject.entities.OrderHistory;
import com.aca.springdata.jpaProject.entities.Products;
import com.aca.springdata.jpaProject.entities.User;
import com.aca.springdata.jpaProject.repos.OrderHistoryRepository;
import com.aca.springdata.jpaProject.repos.ProductsRepository;
import com.aca.springdata.jpaProject.repos.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpaProjectApplicationTests {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	OrderHistoryRepository orderRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateOrder() {
		OrderHistory order = new OrderHistory();
		Timestamp time = new Timestamp(new Date().getTime());
		order.setORDER_ID(4);
		order.setORDER_DATE(time);
		order.setUser(userRepository.findById(4l).get());
		order.setProduct(productsRepository.findById(1l).get());
		
		orderRepository.save(order);
	}
	
//USER TESTS ___________________________________________________________________________________________________
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUSER_ID(4);
		user.setNAME("Dan");
		user.setLAST_NAME("Deeves");
		user.setEMAIL("dunes@gmail.com");
		user.setBIO("Person4");
		user.setAREA_OF_INTEREST("Stuff4");
		
		List<User> emails = userRepository.findByEMAIL(user.getEMAIL());
		if (emails.isEmpty()) {
			userRepository.save(user);
		} else {
			System.out.println("----------------------------------------------\n"
					+ "USER EMAIL TAKEN\n"
					+ "----------------------------------------------");
		}	
	}
	
	@Test
	public void testUpdateUser() {
		User user = userRepository.findById(1L).get();
		user.setEMAIL("acanon@gmail.com");
		user.setAREA_OF_INTEREST("New Stuff");
		
		userRepository.save(user);
	}
	
	@Test
	public void testDeleteUser() {
		userRepository.deleteById(4L);
	}
	
//PRODUCT TESTS _______________________________________________________________________________________________
	@Test
	public void testCreateProduct() {
		List<Products> names = productsRepository.findByNAME("Apple");
		if (names.isEmpty()) {
			Products product = new Products();
			product.setPRODUCT_ID(1);
			product.setNAME("Apple");
			product.setPRICE(5d);
			product.setDESCRIPTION("Red");
			product.setTOTAL_PRODUCTS_INVENTORY(1);
			product.setSTATUS(true);
			
			File file = new File("C:\\Users\\acastroarevalo\\Documents\\Notes\\blue.png");
			byte fileContent[] = new byte[(int)file.length()];
			
			try {
				FileInputStream inputStream = new FileInputStream(file);
				inputStream.read(fileContent);
				product.setIMAGE(fileContent);
				inputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			productsRepository.save(product);
		}else {
			Products product = productsRepository.findByNAME("Apple").get(0);
			product.setTOTAL_PRODUCTS_INVENTORY(product.getTOTAL_PRODUCTS_INVENTORY() + 1);
			productsRepository.save(product);
		}
	}
	
	@Test
	public void testDeleteProduct() {
		Products product = productsRepository.findById(1L).get();
		product.setSTATUS(false);
		productsRepository.save(product);
	}
	
//FINDER TESTS_________________________________________________________________________________________________
	//USER FINDERS-----------------------------------------------------------------------------------------------
	@Test
	public void testFindAllUsers() {
		Iterable<User> users = userRepository.findAll();
		users.forEach(u->System.out.println(u.getNAME() + " " + u.getLAST_NAME()));
	}
	
	@Test
	public void testFindUserByName() {
		List<User> names = userRepository.findByNAME("Ace");
		names.forEach(u->System.out.println(u.getNAME() + " " + u.getLAST_NAME()));
	}
	
	@Test
	public void testFindUserByEmail() {
		List<User> emails = userRepository.findByEMAIL("bulls@gmail.com");
		emails.forEach(u->System.out.println(u.getNAME() + " " + u.getLAST_NAME()));
	}
	
	//PRODUCT FINDERS--------------------------------------------------------------------------------------------
	@Test
	public void testFindAllProducts() {
		Iterable<Products> products = productsRepository.findAll();
		products.forEach(p->System.out.println("Product: " + p.getNAME() + " Price: " + p.getPRICE()));
	}
	
	@Test
	public void testFindProductByName() {
		List<Products> names = productsRepository.findByNAME("Apple");
		names.forEach(p->System.out.println("Product: " + p.getNAME() + " Price: " + p.getPRICE()));
	}
	
	@Test
	public void testFindProductByPrice() {
		List<Products> names = productsRepository.findByPRICE(5d);
		names.forEach(p->System.out.println("Product: " + p.getNAME() + " Price: " + p.getPRICE()));
	}
}
