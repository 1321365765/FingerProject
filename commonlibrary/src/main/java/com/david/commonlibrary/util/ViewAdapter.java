package com.david.commonlibrary.util;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

public class ViewAdapter {
    @BindingAdapter("android:background")
    public static void setBackground(View view,int drawableId){
        view.setBackground(ContextCompat.getDrawable(view.getContext(),drawableId));
    }

    @BindingAdapter("android:src")
    public static void setBackground(ImageView view, Bitmap bitmap){
        view.setImageBitmap(bitmap);

    }
}
