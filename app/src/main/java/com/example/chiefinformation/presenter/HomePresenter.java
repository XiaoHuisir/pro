package com.example.chiefinformation.presenter;


import com.example.chiefinformation.base.BasePresenter;
import com.example.chiefinformation.component.CommonSubscriber;
import com.example.chiefinformation.interfaces.home.HomeConstract;
import com.example.chiefinformation.model.HttpManager;
import com.example.chiefinformation.utils.RxUtils;

public class HomePresenter extends BasePresenter<HomeConstract.View> implements HomeConstract.Presenter {
    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
        .compose(RxUtils.<String>rxScheduler())
        .subscribeWith(new CommonSubscriber<String>(view) {
            @Override
            public void onNext(String response) {
                //view.getHomeData(list);
            }
        }));
    }
}
