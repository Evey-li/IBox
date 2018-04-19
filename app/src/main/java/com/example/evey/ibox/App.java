package com.example.evey.ibox;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Evey on 2018/3/19.
 */

public class App extends Application {
    private static App instance;

    public static App getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SDKInitializer.initialize(getApplicationContext());
    }
}
