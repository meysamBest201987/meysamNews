package com.example.meysmNews.data;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface newsDataSource {
    Single<List<news>> getNews();

}
