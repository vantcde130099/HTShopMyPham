package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.model.Authorities;
import com.shop.model.Customer;
import com.shop.model.User;
import com.shop.repository.CustomerRepository;

@Service
public class CustomerService {

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private AuthoritiesService authoritiesService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	UserService userService;

	public boolean register(Customer customer) {
		List<Authorities> authorities = new ArrayList<Authorities>();

		// get user from input
		User user = customer.getUser();

		// create new Authorities with new user
		Authorities auth = new Authorities("ROLE_CUSTOMER", "Khách hàng", user);
		authorities.add(auth);

		// set Authorities into user
		user.setAuthorities(authorities);

		// encoding password for user
		String passwordEncoded = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordEncoded);
		//theo thứ tự
		return userService.save(user) && authoritiesService.saveAll(authorities) && customerRepository.save(customer) != null;

	}
}
