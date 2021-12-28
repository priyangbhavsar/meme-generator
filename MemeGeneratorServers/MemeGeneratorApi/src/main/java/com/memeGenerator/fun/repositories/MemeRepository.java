package com.memeGenerator.fun.repositories;

import com.memeGenerator.fun.models.vo.Meme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MemeRepository extends CrudRepository<Meme, Integer>, JpaRepository<Meme, Integer>{
    
}
