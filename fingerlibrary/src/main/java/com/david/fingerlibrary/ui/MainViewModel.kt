package com.david.fingerlibrary.ui

import android.app.Application
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.lifecycle.*
import androidx.preference.PreferenceManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItems
import com.david.fingerlibrary.R
import com.david.fingerlibrary.entity.HeandEntity
import timber.log.Timber
import java.util.ArrayList

class MainViewModel(application: Application) : BaseFingerViewModel(application) {
    override fun reData() {

    }

    override fun getStoreDir(): String {
        return "$dir/$store/$user"
    }

    val liveData = MutableLiveData<Bundle>()
    val leftHeandEntity = MutableLiveData<HeandEntity>()
    val rightHeandEntity = MutableLiveData<HeandEntity>()


    init {
        leftHeandEntity.value = HeandEntity()
        rightHeandEntity.value = HeandEntity()

        rightHeandEntity.value!!.initData(getStoreDir(),enrolCount,verifyCount)
        leftHeandEntity.value!!.initData(getStoreDir(),enrolCount,verifyCount)

    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, s: String?) {
        Timber.i("key = $s")

    }


    fun onRightFingerClick(view: View,enrol:Int,verify:Int) {

        val finger = view.tag.toString()
        val args = Bundle()
        args.putString("hand", "right")
        args.putString("finger", finger)

        args.putInt("enrolCount", enrol)
        args.putInt("verifyCount", verify)
        liveData.value = args
    }

    fun onLeftFingerClick(view: View) {
        Timber.i(view.tag.toString())
        val args = Bundle()
        args.putString("hand", "left")
        args.putString("finger", view.tag.toString())
        //获取选择手指的采集的指纹数量
        liveData.value = args
    }


}
