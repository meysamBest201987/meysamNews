package com.example.meysmNews.data;

import com.example.meysmNews.base.ApiService;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class serverDataSource implements newsDataSource {
    private ApiService apiService;
    public serverDataSource(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService=retrofit.create(ApiService.class);
    }
    @Override
    public Single<List<news>> getNews() {
        return apiService.getNews();
    }
}
