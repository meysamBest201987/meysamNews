package com.example.meysmNews.Home;

import com.example.meysmNews.base.basePresenter;
import com.example.meysmNews.base.baseView;
import com.example.meysmNews.data.news;

import java.util.List;

public interface homeContract {
    interface View extends baseView{
           void showNews(List<news> newsList);
           void showError(String error);
    }
    interface Presenter extends basePresenter<View> {
        void getNewsList();
    }
}
