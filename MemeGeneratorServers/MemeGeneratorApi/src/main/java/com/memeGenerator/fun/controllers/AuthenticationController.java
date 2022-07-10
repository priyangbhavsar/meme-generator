package com.memeGenerator.fun.controllers;

import java.io.IOException;
import java.net.HttpCookie;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import com.memeGenerator.fun.models.vo.User;
import com.memeGenerator.fun.repositories.UserRepository;
import com.memeGenerator.fun.service.SessionService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController extends OncePerRequestFilter {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/registerUser")
    public ResponseEntity<Boolean> registerUser(User user) {
        boolean returnValue = this.sessionService.registerUser(user);
        return ResponseEntity.ok().body(returnValue);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(User user, HttpServletResponse response) {
        boolean returnValue = this.sessionService.login(user);
        if (returnValue) {
            Cookie cookie = new Cookie("session-token", user.getGuid());
            response.addCookie(cookie);
        }
        return ResponseEntity.ok().body(returnValue);
    }

    @GetMapping("/verifyToken")
    public ResponseEntity<Boolean> verifyToken(@RequestHeader(value = "token") String token) {
        boolean returnValue = this.sessionService.verifyToken(token);
        return ResponseEntity.ok().body(returnValue);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                filterChain.doFilter(request, response);
    }
}
