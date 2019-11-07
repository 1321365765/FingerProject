package com.david.fingerlibrary.ui

import android.app.Application
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Environment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.preference.PreferenceManager
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream

abstract class BaseFingerViewModel(application: Application) : AndroidViewModel(application),
    LifecycleObserver,
    SharedPreferences.OnSharedPreferenceChangeListener {
    //store 跟user 改变需要执行的操作
    abstract fun reData()
    abstract fun getStoreDir(): String
    //指纹图像
    val image = MutableLiveData<Bitmap>()
    var minScore: Int = 20
    var enrolCount: Int = 40
    var verifyCount: Int = 20
    //用户名称
    var user  = MutableLiveData<String>()
    //保存地址
    var store= MutableLiveData<String>()
    var dir = ""

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, key: String?) {
        Timber.i("key = $key")
        when (key) {
            "verify_count" -> minScore = p0!!.getInt("verify_count", 20)
            "enrol_count" -> enrolCount = p0!!.getInt("enrol_count", 40)
            "verify_count" -> verifyCount = p0!!.getInt("verify_count", 20)
            else -> {

            }
        }

    }

    init {
        val settings = PreferenceManager.getDefaultSharedPreferences(application)
        minScore = settings.getString("verify_count", "20")!!.toInt()
        enrolCount = settings.getString("enrol_count", "40")!!.toInt()
        verifyCount = settings.getString("verify_count", "20")!!.toInt()
        dir = Environment.getExternalStorageDirectory().absolutePath
        user.value= settings.getString("user_name", "")!!
        store.value = settings.getString("store_name", "")!!

    }


    fun saveFile() {
        try {
            val file = File(getStoreDir())
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
            val file = File(getStoreDir())
            val fos = FileOutputStream(file)
            fos.write(bytes, 0, bytes.size)
            fos.flush()
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}