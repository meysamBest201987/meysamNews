package com.example.meysmNews.data;

import java.util.List;

import io.reactivex.Single;

public class localDataSource implements newsDataSource{
    @Override
    public Single<List<news>> getNews() {
        return null;
    }
}
