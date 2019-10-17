package com.example.meysmNews.base;

public interface basePresenter<T extends baseView> {
    void attachView(T view);
    void detach();
}
