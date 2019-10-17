package com.example.meysmNews.data;

import java.util.List;

import io.reactivex.Single;

public class newsRepository implements newsDataSource {
    private localDataSource localDataSource=new localDataSource();
    private serverDataSource serverDataSource=new serverDataSource();
    @Override
    public Single<List<news>> getNews() {
        return serverDataSource.getNews();
    }
}
