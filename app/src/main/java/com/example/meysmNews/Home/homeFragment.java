package com.example.meysmNews.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.meysmNews.R;
import com.example.meysmNews.base.baseFragment;
import com.example.meysmNews.data.news;
import com.example.meysmNews.data.newsRepository;

import java.util.List;

public class homeFragment extends baseFragment implements homeContract.View{
private homeContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new homePresenter(new newsRepository());
    }

    @Override
    public void showNews(List<news> newsList) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public Context getViewContext() {
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }

    @Override
    public void setupView() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }
}
