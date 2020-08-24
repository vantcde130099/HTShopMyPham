package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Authorities;
import com.shop.repository.AuthoritiesRepository;

@Service
public class AuthoritiesService {
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	public List<Authorities> findAll(){
		return authoritiesRepository.findAll();
	}
	
	public Authorities findById(int id) {
		return authoritiesRepository.findById(id);
	}
	
	public boolean save(Authorities authorities) {
		return authoritiesRepository.save(authorities) != null;
	}
	
	public boolean saveAll(List<Authorities> authorities) {
		return authoritiesRepository.saveAll(authorities) != null;
	}
}
