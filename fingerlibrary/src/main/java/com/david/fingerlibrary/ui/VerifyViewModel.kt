package com.david.fingerlibrary.ui

import android.app.Application
import android.content.SharedPreferences
import android.os.Environment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.preference.PreferenceManager
import timber.log.Timber

class VerifyViewModel(application: Application) : BaseFingerViewModel(application) {
    override fun reData() {

    }

    override fun getStoreDir(): String {
        return ""
    }


    init {

    }


}
