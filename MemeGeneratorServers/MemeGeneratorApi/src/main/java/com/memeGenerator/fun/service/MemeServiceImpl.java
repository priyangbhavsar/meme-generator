package com.memeGenerator.fun.service;

import java.util.List;

import javax.transaction.Transactional;

import com.memeGenerator.fun.models.MemeListModel;
import com.memeGenerator.fun.models.MemeListResponseModel;
import com.memeGenerator.fun.models.vo.Meme;
import com.memeGenerator.fun.repositories.MemeCaptionRepository;
import com.memeGenerator.fun.repositories.MemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemeServiceImpl implements MemeService {
    @Autowired
    private MemeRepository memeRepository;
    @Autowired
    private MemeCaptionRepository memeCaptionRepository;

    public MemeListModel getMemeList(int pageNumber, int pageSize) {
        List<Meme> memeList = this.memeRepository.findAll();
        MemeListModel response = new MemeListModel();
        response.setMemeList(memeList);
        return response;
    }

    @Override
    @Transactional
    public MemeListResponseModel getRandomMeme(int pageNumber, int pageSize) {
        MemeListResponseModel responseModel = new MemeListResponseModel();
        try {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            responseModel.setMemeList(this.memeRepository.getRandomMeme(pageable));
            pageable = PageRequest.of(pageNumber, pageSize);
            responseModel.setMemecaptionList(this.memeCaptionRepository.getRandomMemeCaption());
        } catch (Exception e) {
            System.out.println("exception" + e.getMessage());
        }
        return responseModel;
    }
}
