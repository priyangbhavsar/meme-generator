package com.memeGenerator.fun.service;

import com.memeGenerator.fun.models.MemeListModel;

public interface MemeService {
    MemeListModel getMemeList(int pageNumber, int pageSize);
}
