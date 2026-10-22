package com.example.havenproperty

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val usernameInput = email.text.toString().trim()
            val passwordInput = password.text.toString()

            // Cek apakah input kosong
            if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(
                    this,
                    "Username dan password wajib diisi",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (
                usernameInput == "eka@gmail.com" &&
                passwordInput == "haven123"
            ) {
                // Autentikasi berhasil, simpan status login
                val sharedPref = getSharedPreferences(
                    "LoginPrefs",
                    MODE_PRIVATE
                )

                sharedPref.edit()
                    .putBoolean("isLogin", true)
                    .apply()

                Toast.makeText(
                    this,
                    "Login berhasil",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(
                    this,
                    MainActivity::class.java
                )
                startActivity(intent)
                finish()

            } else {
                // Username atau password salah
                Toast.makeText(
                    this,
                    "Username atau password salah",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}