package com.example.havenproperty

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Tombol Lihat Properti
        val btnProperty = findViewById<Button>(R.id.btnProperty)

        btnProperty.setOnClickListener {
            val intent = Intent(this, Property_ListActivity::class.java)
            startActivity(intent)
        }

        // Tombol Tentang Aplikasi
        val btnAbout = findViewById<Button>(R.id.btnAbout)

        btnAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        // Tombol Website
        val btnWebsite = findViewById<Button>(R.id.btnWebsite)

        btnWebsite.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.rumah123.com")
            )
            startActivity(intent)
        }

        // Tombol Profil Developer
        val btnProfile = findViewById<Button>(R.id.btnProfile)

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
