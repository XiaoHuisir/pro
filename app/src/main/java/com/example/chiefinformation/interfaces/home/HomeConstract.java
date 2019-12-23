package com.example.chiefinformation.interfaces.home;



import com.example.chiefinformation.interfaces.IBaseView;
import com.example.chiefinformation.interfaces.IPresenter;

import java.util.List;

public interface HomeConstract {

    interface View extends IBaseView {
        void getHomeData(List<String> list);
    }


    interface Presenter extends IPresenter<View> {
        void getHomeData();
    }
}
