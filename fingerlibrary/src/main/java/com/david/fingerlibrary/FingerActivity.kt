package com.david.fingerlibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.david.commonlibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_finger.*

class FingerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finger)

        lottie_finger.setOnTouchListener { _, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN){
                lottie_finger.playAnimation()
            }else {
                lottie_finger.pauseAnimation()
                lottie_finger.progress = 0f
            }
            return@setOnTouchListener true
        }

    }

    fun showSetting(view:View){
        startActivity(Intent(this, SettingsActivity::class.java))
    }

}
