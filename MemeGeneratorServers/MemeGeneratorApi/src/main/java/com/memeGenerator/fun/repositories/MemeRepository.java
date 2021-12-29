package com.memeGenerator.fun.repositories;

import com.memeGenerator.fun.models.vo.Meme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeRepository extends  JpaRepository<Meme, Integer>{
    
}
