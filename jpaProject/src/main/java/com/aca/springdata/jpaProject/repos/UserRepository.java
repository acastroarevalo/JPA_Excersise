package com.aca.springdata.jpaProject.repos;

import org.springframework.data.repository.CrudRepository;

import com.aca.springdata.jpaProject.entities.User;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByNAME(String nAME);
	
	List<User> findByEMAIL(String eMAIL);
}
