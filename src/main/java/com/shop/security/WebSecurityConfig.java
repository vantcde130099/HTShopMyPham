package com.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.shop.service.UserDetailService;

/**
 * @author Vann Đây là file config spring security thay thế cho file
 *         spring-security.xml
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailService customerDetailService;

	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
		return new MySimpleUrlAuthenticationSuccessHandler();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.authenticationProvider(authenticationProvider());

		auth.userDetailsService(customerDetailService).passwordEncoder(passwordEncoder()); // Cung cáp customerService
																							// cho spring security, cung
																							// cấp password encoder
	}

//	@Override		//cách này thì chạy được
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("van").password(passwordEncoder().encode("vann")).roles("CUSTOMER");
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/index").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
				.antMatchers("/staff/**").hasRole("STAFF")
				.and()
				.formLogin() // Cho phép người dùng xác thực bằng form login
				.successHandler(myAuthenticationSuccessHandler())
//				.permitAll()							// Tất cả đều được truy cập vào địa chỉ này
				.and().logout() // Cho phép logout
				.permitAll();
	}

}
