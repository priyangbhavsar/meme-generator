package com.memeGenerator.fun.models;

import java.util.List;

import com.memeGenerator.fun.models.vo.Meme;

public class MemeListModel {
    private int total;

    private List<Meme> memeList;


    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Meme> getMemeList() {
        return this.memeList;
    }

    public void setMemeList(List<Meme> memeList) {
        this.memeList = memeList;
    }

}
