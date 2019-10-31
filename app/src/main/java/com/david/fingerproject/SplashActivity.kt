package com.david.fingerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieDrawable
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lottie_layer_name.setAnimation(R.raw.fingerprint_scanning)
        lottie_layer_name.speed = 0.4f
        lottie_layer_name.playAnimation()
        lottie_layer_name.addAnimatorUpdateListener {
            if (it.animatedFraction == 0.8f) {
                lottie_layer_name.pauseAnimation()
            }
        }
    }
}
