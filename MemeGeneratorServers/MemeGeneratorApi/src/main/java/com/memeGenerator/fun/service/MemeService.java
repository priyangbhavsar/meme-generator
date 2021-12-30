package com.memeGenerator.fun.service;

import com.memeGenerator.fun.models.MemeListModel;
import com.memeGenerator.fun.models.MemeListResponseModel;

public interface MemeService {
    MemeListModel getMemeList(int pageNumber, int pageSize);

    MemeListResponseModel getRandomMeme(int pageNumber, int pageSize);
}
