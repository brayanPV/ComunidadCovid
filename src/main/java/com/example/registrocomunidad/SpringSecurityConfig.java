package com.example.registrocomunidad;

import com.example.registrocomunidad.loginutils.CustomAuthenticationProvider;
import com.example.registrocomunidad.loginutils.LoginSuccessHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Lazy
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Lazy
    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Lazy
    @Autowired
    private LoginSuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests().antMatchers("/home", "/", "/ufps/login", "/colport/login", "/logout").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
            .successHandler(successHandler)
            .loginPage("/login")
            .defaultSuccessUrl("/index", true)
            //.failureUrl("/home")
            .permitAll()
        .and()
        .logout().logoutSuccessUrl("/")
        .permitAll();
    }

}
