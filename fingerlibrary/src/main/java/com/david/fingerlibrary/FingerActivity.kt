package com.david.fingerlibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.david.fingerlibrary.ui.EnrolViewModel
import com.david.fingerlibrary.ui.VerifyViewModel
import com.david.commonlibrary.base.BaseActivity
import com.david.fingerlibrary.databinding.ActivityFingerBinding
import com.david.fingerlibrary.ui.MainViewModel
import kotlinx.android.synthetic.main.activity_finger.*

class FingerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityFingerBinding>(this, R.layout.activity_finger)

        val enrolViewModel = ViewModelProviders.of(this).get(EnrolViewModel::class.java)
        val verifyViewModel = ViewModelProviders.of(this).get(VerifyViewModel::class.java)
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        lifecycle.addObserver(enrolViewModel)
        lifecycle.addObserver(verifyViewModel)
        lifecycle.addObserver(mainViewModel)

        binding.viewModel = mainViewModel
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return



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
