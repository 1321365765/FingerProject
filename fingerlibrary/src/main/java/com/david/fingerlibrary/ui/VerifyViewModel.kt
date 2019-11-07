package com.david.fingerlibrary.ui

import android.app.Application
import android.content.SharedPreferences
import android.os.Environment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.preference.PreferenceManager
import timber.log.Timber

class VerifyViewModel(application: Application) : BaseFingerViewModel(application) {
    override fun getStoreDir(): String {
        return ""
    }


    override fun onSharedPreferenceChanged(p0: SharedPreferences?, s: String?) {
        Timber.i("key = $s")
        minScore = p0!!.getInt("verify_count", 20)

    }

    init {
        val settings = PreferenceManager.getDefaultSharedPreferences(application)
//        minScore = settings.getInt("verify_count", 20)
//        verifyCount = settings.getInt("verify_count", 20)
    }


}
