package com.example.meysmNews.base;

import com.example.meysmNews.data.news;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("")
    Single<List<news>> getNews();
}
