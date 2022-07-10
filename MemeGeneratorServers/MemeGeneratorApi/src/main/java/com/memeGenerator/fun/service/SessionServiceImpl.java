package com.memeGenerator.fun.service;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.memeGenerator.fun.models.vo.User;
import com.memeGenerator.fun.models.vo.UserSession;
import com.memeGenerator.fun.repositories.UserRepository;
import com.memeGenerator.fun.repositories.UserSessionRepository;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    UserSessionRepository sessionRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean verifyToken(String token) {
        UserSession session = this.sessionRepository.findBySessionToken(token);
        if (session != null) {
            OffsetDateTime currTime = OffsetDateTime.now(Clock.systemUTC());
            if (currTime.minusSeconds(session.getCreatedDate().getSecond()).getHour() <= 24) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean login(User user) {
        Example<User> example = Example.of(user);
        Optional<User> foundUser = this.userRepository.findOneByFirstNameAndLastName(user.getFirstName(), user.getLastName());
        if (foundUser.isPresent()) {
            UserSession userSession = new UserSession();
            userSession.setUser(foundUser.get());
            this.sessionRepository.save(userSession);
            return true;
        }
        return false;
    }

    public boolean registerUser(User user) {
        this.userRepository.save(user);
        return true;
    }

}
