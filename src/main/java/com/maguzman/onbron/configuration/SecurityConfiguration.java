package com.maguzman.onbron.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * Created by maguzman on 11/05/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGloblalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/usuario/**").access("hasRole('USUARIO') and hasRole('SUPER')")
                .antMatchers("/admin/**").access("hasRole('ADMIN') and hasRole('SUPER')")
                .antMatchers("/super/**").access("hasRole('SUPER')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("correo").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/AccesoDenegado");
    }
}
