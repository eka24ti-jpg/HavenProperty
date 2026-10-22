package com.example.havenproperty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PropertyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_property_detail)

        // Judul Toolbar
        supportActionBar?.title = "Detail Properti"

        // Menampilkan tombol Back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Fungsi tombol Back
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
