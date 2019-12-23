package com.example.chiefinformation.constants;




import com.example.chiefinformation.app.MyApp;

import java.io.File;

public class Constant {

    public static final String Base_Url = "http://123.206.58.124:8025/";

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.myApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/project";



}
