package com.aca.springdata.jpaProject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aca.springdata.jpaProject.entities.User;
import com.aca.springdata.jpaProject.repos.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	private UserRepository repository;
	
	UserController(UserRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/users/email/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		return repository.findByEMAIL(email).get(0);
	}
	
	@GetMapping("/users/name/{name}")
	public List<User> getUserByName(@PathVariable("name") String name) {
		return repository.findByNAME(name);
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		List<User> emails = repository.findByEMAIL(user.getEMAIL());
		if (emails.isEmpty()) {
			return repository.save(user);
		}else {
			System.out.println("----------------------------------------------\n"
					+ "USER EMAIL TAKEN\n"
					+ "----------------------------------------------");
		}
		return null;
	}
	
	@PatchMapping("/users/{id}/{email}/{aoe}")
	public User updateUser(@PathVariable("id") long id, @PathVariable("email") String email, @PathVariable("aoe") String aoe) {
		User user = repository.findById(id).get();
		user.setAREA_OF_INTEREST(aoe);
		user.setEMAIL(email);
		return repository.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
}
