package com.david.fingerlibrary.ui

import android.app.Application
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Environment
import androidx.lifecycle.*
import androidx.preference.PreferenceManager
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream

class EnrolViewModel(application: Application) : BaseFingerViewModel(application) {
    override fun reData() {

    }

    override fun getStoreDir(): String {
        return dir + File.separator + store + "/users/enrol/" + user
    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, s: String?) {
        super.onSharedPreferenceChanged(p0, s)

        minScore = p0!!.getInt("verify_count", 20)
        enrolCount = p0.getInt("enrol_count", 40)
    }


    init {
        val settings = PreferenceManager.getDefaultSharedPreferences(application)
        minScore = settings.getString("verify_count", "20")!!.toInt()
        enrolCount = settings.getString("enrol_count", "40")!!.toInt()
    }


    //本次指纹分数 23/20  20代表最低分值
    val score = MutableLiveData<String>()
    //当前采集进度
    val progress = MutableLiveData<Long>()

    /**
     * 选择的手指
     *  小指 Little finger
     *  无名指 Ring finger
     *  中指 middle finger
     *  食指 fore finger
     *  大拇指 thumb
     */
    val fingerName: String = ""

    fun checkProgress() {
        val root = dir + File.separator + store + "/users/enrol/" + user
        val rootFile = File(root)
        if (rootFile.exists()) {
            rootFile.mkdirs()
        }
        progress.value = rootFile.length()
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
