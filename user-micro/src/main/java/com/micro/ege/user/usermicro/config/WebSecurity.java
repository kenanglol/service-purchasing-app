package com.micro.ege.user.usermicro.config;

import com.micro.ege.user.usermicro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment environment;
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, Environment environment) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
        this.environment = environment;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**").permitAll();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    private  AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter =
                new AuthenticationFilter(userService, environment, authenticationManager());
        authenticationFilter.setFilterProcessesUrl(environment.getProperty("user.login.url"));
        return authenticationFilter;
    }
}
