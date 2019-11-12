package com.david.fingerproject

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.david.commonlibrary.base.BaseActivity
import com.david.fingerlibrary.FingerActivity
import com.david.fingerlibrary.SettingsActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit
import io.reactivex.android.schedulers.AndroidSchedulers
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.Window


class SplashActivity : BaseActivity() {
    private val RC_STORAGR_PERM = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()
        lottie_layer_name.setAnimation(R.raw.fingerprint_scanning)
        lottie_layer_name.speed = 0.4f
        lottie_layer_name.playAnimation()
        lottie_layer_name.addAnimatorUpdateListener {
            if (it.animatedFraction == 0.8f) {
                lottie_layer_name.pauseAnimation()
            }
        }

        Observable.timer(5000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                onRequestPermissions()
            }
    }

    @AfterPermissionGranted(123)
    fun onRequestPermissions() {
        if (hasStoragePermission()) {
            startActivity(Intent(this, FingerActivity::class.java))
        } else {
            EasyPermissions.requestPermissions(this, "文件读写",
                RC_STORAGR_PERM, Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
        //ToastUtils.showToast(getApplicationContext(), "用户授权成功");


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            //当从软件设置界面，返回当前程序时候
            AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE -> {
                onRequestPermissions()
            }

        }
    }


}
