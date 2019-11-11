package com.david.commonlibrary.util;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

public class ViewAdapter {
    @BindingAdapter("android:background")
    public static void setBackground(View view,int drawableId){
        view.setBackground(ContextCompat.getDrawable(view.getContext(),drawableId));

    }
}
