package com.memeGenerator.fun.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.memeGenerator.fun.models.vo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByFirstNameAndLastName(String firstName, String lastName);
}
