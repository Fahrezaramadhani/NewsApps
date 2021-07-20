package com.example.mynews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mynews.model.NewsResponse;
import com.example.mynews.networking.NewsRepository;

public class NewsViewModel extends ViewModel {
    private static String KEY = "8cb741d08e724bc28dd681dbd16220b0";
    private MutableLiveData<NewsResponse> mutableLiveData;
    private NewsRepository newsRepository;

    public void topHeadline(String country){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNews(country, KEY);

    }
    public void getNewsEverythingFilter(String keyword){
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNewsEverythingFilter(keyword, KEY);

    }
    public LiveData<NewsResponse> getNewsRepository() {
        return mutableLiveData;
    }
}
