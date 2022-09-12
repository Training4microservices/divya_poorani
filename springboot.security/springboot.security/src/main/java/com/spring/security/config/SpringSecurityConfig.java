package com.spring.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig implements SpringSecurityCon {
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    // security for all API

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("training").password("password").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("java").password("password").roles("USER");
    }


    // security based on URL


/*
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable();
	 http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and
	  ().httpBasic(); }*/


    // security based on ROLE
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN")
		.anyRequest().fullyAuthenticated().and()
				.httpBasic();
	}*/

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().
                httpBasic();
    }
}
