package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Customer;
import com.shop.repository.CustomerRepository;

@Service
public class CustomerDetailService implements UserDetailsService {
	@Autowired
	private CustomerRepository customerRepository;

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public boolean login(Customer customer) {
		Customer savedCustomer = customerRepository.findByUserNameAndPassword(customer.getUserName(),
				customer.getPassword());
		return (savedCustomer != null);
	}

	public boolean register(Customer customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		return customerRepository.save(customer) != null;
	}

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByUserName(username);
		
		UserBuilder builder = null;
		if(customer!= null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(!customer.isEnabled());
			builder.password(customer.getPassword());
			builder.authorities(customer.getAuthority());
		}
		else {
			throw new UsernameNotFoundException("Customer not found");
		}
		//return new CustomCustomerDetail(customer);
		return builder.build();
	}
}
