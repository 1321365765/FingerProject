package com.david.commonlibrary.base;

import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.david.commonlibrary.BuildConfig;
import com.david.commonlibrary.entity.FileLoggingTree;

import timber.log.Timber;

public class BaseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG){
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险
        }
        ARouter.init(this);
        //初始化log
        Timber.plant(new FileLoggingTree());
    }
}
