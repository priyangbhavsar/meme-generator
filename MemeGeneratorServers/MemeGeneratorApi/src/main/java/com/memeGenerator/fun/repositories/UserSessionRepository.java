package com.memeGenerator.fun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.memeGenerator.fun.models.vo.UserSession;

public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {

    UserSession findBySessionToken(String sessionToken);
}
