package com.david.commonlibrary.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;


import androidx.annotation.RequiresApi;

import java.util.Locale;

import timber.log.Timber;

public class LanguageUtil {
    public static Context initAppLanguage(Context context, String language) {

        if (currentLanguageIsSimpleChinese(context)) {
            Timber.e( "当前是简体中文");
            return context;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //7.0及以上的方法
             Timber.e(  "7.0及以上");
            return createConfiguration(context, language);
        } else {
             Timber.e(  "7.0以下");
            updateConfiguration(context, language);
            return context;
        }
    }

    /**
     * 7.0及以上的修改app语言的方法
     *
     * @param context  context
     * @param language language
     * @return context
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static Context createConfiguration(Context context, String language) {
        Resources resources = context.getResources();
        Locale locale = new Locale(language);
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        LocaleList localeList = new LocaleList(locale);
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        return context.createConfigurationContext(configuration);
    }

    /**
     * 7.0以下的修改app语言的方法
     *
     * @param context  context
     * @param language language
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private static void updateConfiguration(Context context, String language) {
        Resources resources = context.getResources();
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        resources.updateConfiguration(configuration, displayMetrics);
    }

    /**
     * 判断当前的语言是否是简体中文
     *
     * @param context context
     * @return boolean
     */
    private static boolean currentLanguageIsSimpleChinese(Context context) {
        String language;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            language = context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        } else {
            language = context.getResources().getConfiguration().locale.getLanguage();
        }
        //Locale.ENGLISH
        Timber.e(  "language = %s", language);
        return TextUtils.equals("zh", language);
    }
}
