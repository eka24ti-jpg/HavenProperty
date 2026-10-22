
package com.example.havenproperty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_about)

        // Judul Toolbar
        supportActionBar?.title = "Tentang Aplikasi"

        // Menampilkan tombol Back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Fungsi tombol Back
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}

