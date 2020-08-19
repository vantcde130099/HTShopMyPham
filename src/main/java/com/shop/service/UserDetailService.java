package com.shop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.User;
import com.shop.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public boolean login(User user) {
		User savedUser = userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
		return (savedUser != null);
	}

	public boolean register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user) != null;
	}

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		UserBuilder builder = null;
		if(user!= null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(!user.isEnabled());
			builder.password(user.getPassword());
			//String[] authorities = (String[]) user.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String :: new);
			//List<SimpleGrantedAuthority> grantedAuthorities =  user.getAuthorities()).map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList()); // (1)
			List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
	                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
	            .collect(Collectors.toList());
			builder.authorities(grantedAuthorities);
		}
		else {
			throw new UsernameNotFoundException("Customer not found");
		}
		//return new CustomCustomerDetail(customer);
		return builder.build();
	}
}
