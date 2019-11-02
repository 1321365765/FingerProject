package com.david.fingerproject;

import android.os.Handler;
import android.os.Looper;

import com.david.commonlibrary.base.BaseApplication;


public class App extends BaseApplication {
    private Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler(Looper.getMainLooper());
    }
}
