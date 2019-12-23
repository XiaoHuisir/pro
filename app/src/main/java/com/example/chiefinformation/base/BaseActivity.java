package com.example.chiefinformation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.chiefinformation.R;
import com.example.chiefinformation.interfaces.IBaseView;
import com.example.chiefinformation.interfaces.IPresenter;
import com.example.chiefinformation.utils.SystemUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IBaseView {


    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract P createPresenter();

    @BindView(R.id.layout_tips)
    ConstraintLayout layout_tips;

    //p层
    protected P presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(getLayout());
        ButterKnife.bind(this);
        initView();
        initData();
        presenter = createPresenter();
        if(presenter != null) presenter.attachView(this);
        checkNet();
    }

    /**
     * 检查网络状态
     */
    private void checkNet(){
        if(!SystemUtils.checkNetWork()){
            layout_tips.setVisibility(View.VISIBLE);
        }else{
            layout_tips.setVisibility(View.GONE);
        }
    }
}
