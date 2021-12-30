package com.memeGenerator.fun.models;

import java.util.List;

import com.memeGenerator.fun.models.vo.Meme;
import com.memeGenerator.fun.models.vo.MemeCaption;

public class MemeListResponseModel {
    private List<Meme> memeList;

    private List<MemeCaption> memecaptionList;


    public List<Meme> getMemeList() {
        return this.memeList;
    }

    public void setMemeList(List<Meme> memeList) {
        this.memeList = memeList;
    }

    public List<MemeCaption> getMemecaptionList() {
        return this.memecaptionList;
    }

    public void setMemecaptionList(List<MemeCaption> memecaptionList) {
        this.memecaptionList = memecaptionList;
    }

}
