package com.shop;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

	public static void main(String[] args) {
		System.out.println(new BCryptPassswordEncoder().encode("123"));
		System.out.println(new BCryptPasswordEncoder().matches("trungnam", "$2a$10$n9p3iZMeuoziqsT3qGi6F.omlsjYXjLflIsgstO/DanvqXFapgDDq"));
		
		
	}

}
