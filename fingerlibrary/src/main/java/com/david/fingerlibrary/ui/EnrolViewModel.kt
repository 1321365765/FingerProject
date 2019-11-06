package com.david.fingerlibrary.ui

import android.app.Application
import android.graphics.Bitmap
import android.os.Environment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import java.io.File
import java.io.FileOutputStream

class EnrolViewModel(application: Application) : AndroidViewModel(application) {

    init{
        val settings = PreferenceManager.getDefaultSharedPreferences(application)
        val minScore = settings.getInt("verify_count",20)
    }

    //指纹图像
    val image = MutableLiveData<Bitmap>()
    //本次指纹分数 23/20  20代表最低分值
    val score = MutableLiveData<String>()
    //当前采集进度
    val progress = MutableLiveData<Int>()

    val dir = Environment.getExternalStorageDirectory().absolutePath

    //用户名称
    val user: String = ""
    //保存地址
    val store: String = ""


    fun checkProgress() {

    }

    fun saveFile() {
        try {
            val file = File(dir + "test.png")
            val out = FileOutputStream(file)
            image.value!!.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush()
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

   fun bytesToImageFile( bytes:ByteArray ) {
        try {
            val file = File(dir + "test.png")
            val fos =  FileOutputStream(file)
            fos.write(bytes, 0, bytes.size)
            fos.flush()
            fos.close()
        } catch (e:Exception ) {
            e.printStackTrace()
        }
    }

}
