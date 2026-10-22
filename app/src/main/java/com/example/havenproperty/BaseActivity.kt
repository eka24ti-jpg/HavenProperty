package com.example.havenproperty


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class BaseActivity : AppCompatActivity() {


    private lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)


        bottomNavigation = findViewById(R.id.bottomNavigation)


        if (savedInstanceState == null) {
            bottomNavigation.selectedItemId = R.id.nav_home
            replaceFragment(HomeFragment())
        }


        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }


                R.id.nav_properties -> {
                    replaceFragment(PropertiesFragment())
                    true
                }


                R.id.nav_about -> {
                    replaceFragment(AboutFragment())
                    true
                }


                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }


                else -> false
            }
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}

