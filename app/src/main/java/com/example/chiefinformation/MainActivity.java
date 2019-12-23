package com.example.chiefinformation;


import android.support.design.widget.BottomNavigationView;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.chiefinformation.base.BaseActivity;
import com.example.chiefinformation.interfaces.IPresenter;


public class MainActivity extends BaseActivity {
    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_classify:
                    return true;
                case R.id.navigation_mine:
                    return true;
            }
            return false;
        }
    };



    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    @Override
    protected void initData() {

    }
    @Override
    protected IPresenter createPresenter() {
        return null;
    }
    @Override
    public void showError(String err) {

    }
}
