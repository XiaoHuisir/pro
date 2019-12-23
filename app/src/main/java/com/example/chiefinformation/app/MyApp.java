package com.example.chiefinformation.app;

import android.app.Application;

public class MyApp extends Application {
    public static Application myApp;
    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }
}
