package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.model.Customer;
import com.shop.repository.CustomerRepository;
@Service
public class CustomerService {

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	CustomerRepository customerRepository;
	
	public boolean register(Customer customer) {
		customer.getUser().setPassword(passwordEncoder.encode(customer.getUser().getPassword()));
		return customerRepository.save(customer) != null;
	}
}
