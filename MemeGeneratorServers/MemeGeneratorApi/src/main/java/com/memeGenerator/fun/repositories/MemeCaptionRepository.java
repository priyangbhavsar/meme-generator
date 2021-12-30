package com.memeGenerator.fun.repositories;

import java.util.List;

import com.memeGenerator.fun.models.vo.MemeCaption;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemeCaptionRepository extends JpaRepository<MemeCaption, Integer> {
    @Query(value = "select *from meme_caption order by rand()", nativeQuery = true)
    List<MemeCaption> getRandomMemeCaption(Pageable pageable);

    @Query(value = "select *from meme_caption order by rand()", nativeQuery = true)
    List<MemeCaption> getRandomMemeCaption();
}
