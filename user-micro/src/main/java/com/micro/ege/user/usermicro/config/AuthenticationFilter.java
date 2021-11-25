package com.micro.ege.user.usermicro.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.ege.user.usermicro.service.GetUserServiceInput;
import com.micro.ege.user.usermicro.service.GetUserServiceOutput;
import com.micro.ege.user.usermicro.service.LoginUser;
import com.micro.ege.user.usermicro.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
public class AuthenticationFilter  extends UsernamePasswordAuthenticationFilter {

    private UserService userService;
    private Environment environment;

    public AuthenticationFilter(UserService userService, Environment environment,
                                AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.environment = environment;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            LoginUser logUser = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginUser.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            logUser.getMail(),
                            logUser.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult)
            throws IOException, ServletException {
        String username = ((User) authResult.getPrincipal()).getUsername();
        GetUserServiceOutput result = null;
        GetUserServiceInput input = new GetUserServiceInput();
        input.setMail(username);
        try {
            result = userService.getUser(input);
        } catch (DataNotFoundException e) {
            log.error("Get user input service error : ",input);
        }
        String token = Jwts.builder()
                .setSubject(input.getUserId())
                .setExpiration(new Date(System.currentTimeMillis() +
                        Long.parseLong(environment.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret") )
                .compact();

        response.addHeader("token", token);
        response.addHeader("userId", result.getUserId());
    }
}
