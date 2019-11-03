package com.david.fingerlibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.david.fingerlibrary.ui.EnrolViewModel
import kotlinx.android.synthetic.main.activity_finger.*

class FingerActivity : AppCompatActivity() {
    private var x1 = 0f
    private var x2 = 0f
    private var y1 = 0f
    private var y2 = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finger)

        val enrolViewModel = ViewModelProviders.of(this).get(EnrolViewModel::class.java)
        lifecycle.addObserver(enrolViewModel)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return




        lottie_finger.setOnTouchListener { _, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                lottie_finger.playAnimation()
            } else {
                lottie_finger.pauseAnimation()
                lottie_finger.progress = 0f
            }
            return@setOnTouchListener true
        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //继承了Activity的onTouchEvent方法，直接监听点击事件
        if (event!!.action == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.x
            y1 = event.y
        }
        if (event.action == MotionEvent.ACTION_MOVE) {
            //当手指移动的时候
            x2 = event.x
            y2 = event.y
            if (y1 - y2 > 50) {
                Toast.makeText(this, "向上滑", Toast.LENGTH_SHORT).show()
            } else if (y2 - y1 > 50) {
                Toast.makeText(this, "向下滑", Toast.LENGTH_SHORT).show()
            } else if (x1 - x2 > 50) {
                Toast.makeText(this, "向左滑", Toast.LENGTH_SHORT).show()
            } else if (x2 - x1 > 50) {
                Toast.makeText(this, "向右滑", Toast.LENGTH_SHORT).show()
            }
        }
        if (event.action == MotionEvent.ACTION_UP) {

        }
        return super.onTouchEvent(event)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.finger_main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.tv_setting) {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


    fun showSetting(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

}
