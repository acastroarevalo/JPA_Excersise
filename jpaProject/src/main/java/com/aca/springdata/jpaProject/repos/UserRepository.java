package com.aca.springdata.jpaProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aca.springdata.jpaProject.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByNAME(String nAME);
	
	List<User> findByEMAIL(String eMAIL);
	
}
