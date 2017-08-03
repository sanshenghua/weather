package com.weather.android;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * Created by zhancongcong on 2017/8/2.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        //super.onCreate();
        context = getApplicationContext();
        LitePalApplication.initialize(context);
    }
    public static Context getContext(){
        return context;
    }
}
