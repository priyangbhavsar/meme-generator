package com.memeGenerator.fun.repositories;


import java.util.List;

import com.memeGenerator.fun.models.vo.Meme;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemeRepository extends JpaRepository<Meme, Integer> {

    @Query(value = "select *from meme order by rand()", nativeQuery = true)
    List<Meme> getRandomMeme(Pageable pageable);

}
