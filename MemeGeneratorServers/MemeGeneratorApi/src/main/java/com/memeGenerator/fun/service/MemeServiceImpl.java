package com.memeGenerator.fun.service;

import java.util.List;

import com.memeGenerator.fun.models.MemeListModel;
import com.memeGenerator.fun.models.vo.Meme;
import com.memeGenerator.fun.repositories.MemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeServiceImpl implements MemeService {
    @Autowired
    private MemeRepository repository;

    public MemeListModel getMemeList(int pageNumber, int pageSize) {
        List<Meme> memeList = this.repository.findAll();
        MemeListModel response = new MemeListModel();
        response.setMemeList(memeList);
        return response;
    }
}
