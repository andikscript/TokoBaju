package com.andik.utsmobiledua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.andik.utsmobiledua.ui.fragment.HomeFragment
import com.andik.utsmobiledua.ui.fragment.InputFragment
import com.andik.utsmobiledua.ui.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var menu : Menu;
    private lateinit var menuItem : MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNav()
        callFragment(0, HomeFragment())
    }

    private fun setBottomNav() {
        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    callFragment(0, HomeFragment())
                }

                R.id.input -> {
                    callFragment(1, InputFragment())
                }

                R.id.settings -> {
                    callFragment(2, SettingsFragment())
                }
            }
            false
        }
    }

    private fun callFragment(int : Int, fragment: Fragment) {
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        callFragment(fragment)
    }

    private fun callFragment(f : Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, f)
                .commit()
    }
}