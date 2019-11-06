package com.david.commonlibrary.base;

import android.content.Context;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;

import com.david.commonlibrary.util.LanguageUtil;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            super.attachBaseContext(newBase);
        } else {
            super.attachBaseContext(LanguageUtil.initAppLanguage(newBase, "zh"));
        }
    }
}
