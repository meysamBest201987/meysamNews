package com.example.meysmNews.Home;

import com.example.meysmNews.data.news;
import com.example.meysmNews.data.newsDataSource;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.Scheduler;

public class homePresenter implements homeContract.Presenter {
    private homeContract.View view;
    private newsDataSource newsDataSource;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public homePresenter(newsDataSource newsDataSource){
        this.newsDataSource=newsDataSource;
    }

    public homePresenter() {
    }

    @Override
    public void getNewsList() {
        newsDataSource.getNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<news>>() {
                    private Object news;

                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);

                    }

                    @Override
                    public void onSuccess(List<news> newsList) {
                        view.showNews(newsList);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());

                    }
                });

    }

    @Override
    public void attachView(homeContract.View view) {
        this.view=view;

    }

    @Override
    public void detach() {
        this.view=null;
        if(compositeDisposable!=null && compositeDisposable.size()>0){
            compositeDisposable.clear();
        }

    }
}
