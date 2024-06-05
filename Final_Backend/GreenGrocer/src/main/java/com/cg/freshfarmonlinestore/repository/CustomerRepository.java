package com.cg.freshfarmonlinestore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.freshfarmonlinestore.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	// finds customer by their customer Id
	Optional<Customer> findByCustomerId(long customerId);
	
	// finds customer by their username
	Optional<Customer> findByUserName(String userName);

	// check for existance of username
	Boolean existsByUserName(String userName);
	
	// check for existance of email
	Boolean existsByEmail(String email);
	
	// find user by username or email
	Optional<Customer> findByUserNameOrEmail(String userName, String email);
	
	// check for existance by customer Id
	Boolean existsByCustomerId(long customerId);
	
	// to get max number of customer Id
	@Query("SELECT COALESCE(MAX(c.customerId), 0) FROM Customer c")
    long findMaxCustomerId();
	
	// Search by name, email (partial match)
	List<Customer> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);

}
