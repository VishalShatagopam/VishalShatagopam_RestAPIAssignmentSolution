package com.greatlearning.employee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.greatlearning.employee.service.MyUserDetailsService;





@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	MyUserDetailsService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);

	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console", "/h2-console/**");

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/employees/{id}","/list", "/delete/{id}","/add","/save","/update","/employees/search/{firstName}","/addRole","/addUser")
		.hasRole("ADMIN")
		.antMatchers("/list","/update","/employees/{id}")
		.hasAnyRole("ADMIN","USER")
		.anyRequest().authenticated().and()
		.formLogin().and().logout().and().cors().and().csrf().disable();
		
	}
}
	

