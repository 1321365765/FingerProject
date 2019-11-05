package com.david.fingerlibrary.ui

import android.app.Application
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.preference.PreferenceManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItems
import com.david.fingerlibrary.R
import timber.log.Timber

class MainViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver,
    SharedPreferences.OnSharedPreferenceChangeListener {
    var navigate: Navigate? = null

    interface Navigate {
        fun navigate(@IdRes resId: Int, @Nullable args: Bundle)
    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, s: String?) {
        Timber.i("key = $s")
    }


    fun onRightFingerClick(view: View) {
    }

    fun onLeftFingerClick(view: View) {
        //获取选择手指的采集的指纹数量

        MaterialDialog(view.context)
            .listItems { dialog, index, text ->

            }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        PreferenceManager.getDefaultSharedPreferences(getApplication())
            .registerOnSharedPreferenceChangeListener(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        PreferenceManager.getDefaultSharedPreferences(getApplication())
            .unregisterOnSharedPreferenceChangeListener(this)
    }
}
