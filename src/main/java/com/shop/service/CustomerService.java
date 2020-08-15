package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Customer;
import com.shop.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public boolean login(Customer customer) {
		Customer savedCustomer = customerRepository.findByUserNameAndPassword(customer.getUserName(), customer.getPassword());
		return (savedCustomer != null);
	}

	public boolean register(Customer customer) {
		return customerRepository.save(customer) != null;
	}
}
