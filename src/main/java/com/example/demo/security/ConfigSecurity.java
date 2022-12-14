package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {
	
	@Autowired
	private UserDetailService service;
	
	@Autowired
	private TokenFilter filter;
	
	@Autowired
	private EntryPoint entrypoint;

	/*@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("PROFESOR").password(encriptado().encode("123")).roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("ALUMNO").password(encriptado().encode("123")).roles("USER");
		auth.userDetailsService(service).passwordEncoder(encriptado());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/producto/v1/guardar").access("hasRole('ADMIN')")
//			.antMatchers("/producto/v1/listar").permitAll()
//			.and()
//			.httpBasic()
//			.and()
//			.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/crearToken").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(entrypoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
			.csrf().disable();
		
	}

	
//	@Bean
//	public UserDetailsService userDetail() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(
//				User.withUsername("profesor")
//				.password(encriptado().encode("123"))
//				.roles("ADMIN")
//				.build());
//		return manager;
//	}
//	
	@Bean
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		
//		http.authorizeRequests()
//			.antMatchers("/producto/v1/*").access("hasRole('ADMIN')")
//			.and()
//			.httpBasic()
//			.and()
//			.csrf().disable();
//		
//		return http.build();
//	}*/
	
}
