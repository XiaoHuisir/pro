package com.example.chiefinformation.base;

import com.example.chiefinformation.interfaces.IBaseView;
import com.example.chiefinformation.interfaces.IPresenter;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 处理界面数据加载的内存泄漏问题
 * @param <V>
 */
public class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    //当前关联的View层
    protected V view;
    private WeakReference<V> weakReference;

    protected CompositeDisposable compositeDisposable;

    @Override
    public void attachView(V v) {
        weakReference = new WeakReference<>(v);
        view = weakReference.get();
    }

    /**
     * 数据加载请求对象的添加
     * @param disposable
     */
    protected void addSubscribe(Disposable disposable){
        if(compositeDisposable == null) compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }

    /**
     * 释放缓存中的数据加载对象
     */
    protected void unSubscribe(){
        if(compositeDisposable != null) compositeDisposable.clear();
    }

    /**
     * 界面移除的时候释放view层的应用
     */
    @Override
    public void detachView() {
        view = null;
        unSubscribe();
    }
}
