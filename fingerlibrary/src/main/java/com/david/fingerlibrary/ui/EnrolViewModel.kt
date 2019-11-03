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

class EnrolViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver,
    SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onSharedPreferenceChanged(p0: SharedPreferences?, s: String?) {
        Timber.i("key = $s")
        minScore = p0!!.getInt("verify_count", 20)
        enrolCount = p0.getInt("enrol_count", 40)
    }

    var minScore: Int = 0
    var enrolCount: Int = 40
    var dir = ""

    init {
        val settings = PreferenceManager.getDefaultSharedPreferences(application)
        minScore = settings.getInt("verify_count", 20)
        enrolCount = settings.getInt("enrol_count", 40)
        dir = Environment.getExternalStorageDirectory().absolutePath
    }

    //指纹图像
    val image = MutableLiveData<Bitmap>()
    //本次指纹分数 23/20  20代表最低分值
    val score = MutableLiveData<String>()
    //当前采集进度
    val progress = MutableLiveData<Long>()

    //用户名称
    val user: String = ""
    //保存地址
    val store: String = ""
    /**
     * 选择的手指
     *  小指 Little finger
     *  无名指 Ring finger
     *  中指 middle
     *  食指 forefinger
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


    fun saveFile() {
        try {
            val file = File(dir + "test.png")
            val out = FileOutputStream(file)
            image.value!!.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.flush()
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun bytesToImageFile(bytes: ByteArray) {
        try {
            val file = File(dir + "test.png")
            val fos = FileOutputStream(file)
            fos.write(bytes, 0, bytes.size)
            fos.flush()
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
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
