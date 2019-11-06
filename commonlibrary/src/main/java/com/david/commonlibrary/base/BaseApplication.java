package com.david.commonlibrary.base;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.david.commonlibrary.BuildConfig;
import com.david.commonlibrary.entity.FileLoggingTree;
import com.david.commonlibrary.util.LanguageUtil;

import timber.log.Timber;

public class BaseApplication extends MultiDexApplication implements Application.ActivityLifecycleCallbacks {
    private boolean isRunInBackground;
    private int appCount;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险
        }
        ARouter.init(this);
        //初始化log
        Timber.plant(new FileLoggingTree());
        registerActivityLifecycleCallbacks(this);

        initLanguage();
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        appCount++;
        if (isRunInBackground) {
            Timber.i("从后台进入前台");
            isRunInBackground = false;
            //防止应用程序切换到后台，然后通过设置设置语言，最后再将应用程序从后台切换回前台的情况
            initLanguage();
        }
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }


    private void initLanguage() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            //Application这种方式适用于8.0之前(不包括8.0)的版本
            LanguageUtil.initAppLanguage(getApplicationContext(), "zh");
        }
    }

}
