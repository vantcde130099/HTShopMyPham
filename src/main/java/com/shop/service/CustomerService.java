package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.model.Customer;
import com.shop.repository.CustomerRepository;
import com.shop.security.CustomCustomerDetail;

@Service
public class CustomerService implements UserDetailsService{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Customer customer = customerRepository.findByUserName(username);
		if(customer == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomCustomerDetail(customer);
	}

	public boolean login(Customer customer) {
		Customer savedCustomer = customerRepository.findByUserNameAndPassword(customer.getUserName(), customer.getPassword());
		return (savedCustomer != null);
	}

	public boolean register(Customer customer) {
		return customerRepository.save(customer) != null;
	}
}
