package com.memeGenerator.fun.service;

import org.springframework.stereotype.Service;

import com.memeGenerator.fun.models.vo.User;


public interface SessionService {
    public boolean verifyToken(String token);

    public boolean login(User user);

    public boolean registerUser(User user);

}
