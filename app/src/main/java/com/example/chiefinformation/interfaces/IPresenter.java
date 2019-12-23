package com.example.chiefinformation.interfaces;

public interface IPresenter<V extends IBaseView> {

    void attachView(V view);

    void detachView();

}
