package com.example.havenproperty

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    private val navigateRunnable = Runnable {
        val sharedPref = getSharedPreferences(
            "LoginPrefs",
            MODE_PRIVATE
        )

        val isLogin = sharedPref.getBoolean(
            "isLogin",
            false
        )

        val destination = if (isLogin) {
            MainActivity::class.java
        } else {
            LoginActivity::class.java
        }

        startActivity(Intent(this, destination))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler.postDelayed(navigateRunnable, 2000)
    }

    override fun onDestroy() {
        handler.removeCallbacks(navigateRunnable)
        super.onDestroy()
    }
}