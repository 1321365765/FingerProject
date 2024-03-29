package com.david.fingerlibrary

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.david.fingerlibrary.Preference.TextPreference
import timber.log.Timber


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, SettingsFragment())
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        Timber.i(settings.getString("signature", "default").toString())

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }



    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
            val sp = preferenceScreen.sharedPreferences
            val list = findPreference<ListPreference>("device_name")
            //list.setEntryValues()
            val textPreference = findPreference<TextPreference>("test")

            Timber.i(sp.getString("signature", "default").toString())

        }
    }
}