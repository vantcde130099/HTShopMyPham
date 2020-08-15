package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findByUserNameAndPassword(String username, String password);
	
	Customer findByUserName(String username);
//	public boolean authenticate(Customer customer) {
//		if(customer.getUserName().equals(customer.getPassword())) {
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean register(Customer customer) {
//		if(customer.getUserName().equals(customer.getPassword())) {
//			return true;
//		}
//		return false;
//		
//	}

}
