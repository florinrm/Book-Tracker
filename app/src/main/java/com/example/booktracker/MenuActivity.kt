package com.example.booktracker

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.booktracker.menu.MenuFragment
import com.example.booktracker.menu.MenuFragmentDirections
import com.example.booktracker.menu.MenuViewModel
import timber.log.Timber

const val THEME_MODE_AUTO = "theme_mode_auto"
const val THEME_MODE_DAY = "theme_mode_day"
const val THEME_MODE_NIGHT = "theme_mode_night"

const val SHR_PREF_KEY_THEME_MODE = "KEY_THEME_MODE"


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        setContentView(R.layout.activity_menu)
        setAppThemeMode()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        menuInflater.inflate(R.menu.app_bar_menu, menu)

        val searchItem = menu?.findItem(R.id.search_button)
        val searchView = searchItem?.actionView as SearchView

        searchView.queryHint = "Search in your books"
        searchView.findViewById<AutoCompleteTextView>(R.id.search_src_text).threshold = 1

        navHostFragment.findNavController()
            .addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.settingsFragment -> {
                        supportActionBar?.setDisplayShowTitleEnabled(true)
                        supportActionBar?.title = "Settings"
                    }
                    R.id.addBookFragment -> {
                        supportActionBar?.setDisplayShowTitleEnabled(true)
                        supportActionBar?.title = "Add a Book"
                    }
                    else -> {
                        supportActionBar?.setDisplayShowTitleEnabled(true)
                        supportActionBar?.title = "Book Tracker"
                    }
                }
            }

        navHostFragment.findNavController()
            .addOnDestinationChangedListener { _, destination, _ ->
                when(destination.id) {
                    R.id.menuFragment -> {
                        supportActionBar?.setDisplayHomeAsUpEnabled(false)

                        menu.findItem(R.id.search_button).isVisible = true
                        menu.findItem(R.id.sort_books_button).isVisible = true
                        menu.findItem(R.id.nearby_libraries_button).isVisible = true
                        menu.findItem(R.id.settings_button).isVisible = true
                        menu.findItem(R.id.sign_out_button).isVisible = true
                    }
                    else -> {
                        if (destination.id == R.id.settingsFragment || destination.id == R.id.addBookFragment) {
                            supportActionBar?.setDisplayHomeAsUpEnabled(true)
                        }

                        searchView.isIconified = true

                        menu.findItem(R.id.search_button).isVisible = false
                        menu.findItem(R.id.sort_books_button).isVisible = false
                        menu.findItem(R.id.nearby_libraries_button).isVisible = false
                        menu.findItem(R.id.settings_button).isVisible = false
                        menu.findItem(R.id.sign_out_button).isVisible = false
                    }
                }
            }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        when (item.itemId) {
            R.id.settings_button -> navHostFragment.findNavController().navigate(R.id.settingsFragment)
            R.id.nearby_libraries_button -> {
                val gmmIntentUri = Uri.parse("geo:0,0?q=book+shops")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
            R.id.sign_out_button -> {
                // Handled in MenuFragment
                return false
            }
            R.id.search_button -> onSearchRequested()
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    private fun setAppThemeMode(){
        var sharedPreferencesName = "com.example.booktracker_preferences"
        val sharedPref = getSharedPreferences(sharedPreferencesName, MODE_PRIVATE)

        var accent = sharedPref.getString(SHR_PREF_KEY_THEME_MODE,
                                          THEME_MODE_AUTO).toString()

        when(accent){
            THEME_MODE_AUTO -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            THEME_MODE_DAY -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            THEME_MODE_NIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}