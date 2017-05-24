package com.maguzman.onbron.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


/**
 * Created by maguzman on 11/05/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    PersistentTokenRepository tokenRepository;

    //HibernateTokenRepositoryImpl tokenRepository;

    @Autowired
    public void configureGloblalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/", "/home", "/registrarse", "/forgotPassword").permitAll()
                .antMatchers("/user/**").access("hasRole('USUARIO') and hasRole('SUPER')")
                .antMatchers("/admin/**").access("hasRole('ADMIN') and hasRole('SUPER')")
                .antMatchers("/super/**").access("hasRole('SUPER')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("correo").passwordParameter("password")
                .defaultSuccessUrl("/usuario")
                .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
                .tokenValiditySeconds(86400)
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/AccesoDenegado");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeService(){
        PersistentTokenBasedRememberMeServices tokenBasedServices = new PersistentTokenBasedRememberMeServices(
                "remember-me", userDetailsService, tokenRepository);
        return tokenBasedServices;
    }
    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver   () {
        return new AuthenticationTrustResolverImpl();
    }

}
