package com.example.booktracker.settings

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.example.booktracker.R

const val SHR_PREF_REFRESHED = "REFRESHED"
const val SHR_PREF_KEY_THEME_MODE = "KEY_THEME_MODE"

class SettingsFragment : PreferenceFragmentCompat(), OnSharedPreferenceChangeListener {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences
            .registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences
            .unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        if (activity == null)
            return

        if (key == SHR_PREF_KEY_THEME_MODE) {
            val sharedPref = PreferenceManager.getDefaultSharedPreferences(activity)
            sharedPref.edit().putBoolean(SHR_PREF_REFRESHED, true).apply()
            activity?.recreate()
        }
    }
}