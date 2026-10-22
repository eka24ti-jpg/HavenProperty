package com.example.havenproperty

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class VerificationActivity : AppCompatActivity() {

    private val prefs by lazy {
        getSharedPreferences("RegistrationPrefs", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        val nama = prefs.getString("nama", "") ?: ""
        val email = prefs.getString("email", "") ?: ""
        val tanggal = prefs.getString("tanggalLahir", "") ?: ""
        val gender = prefs.getString("gender", "") ?: ""
        val username = prefs.getString("username", "") ?: ""
        val password = prefs.getString("password", "") ?: ""
        val confirm = prefs.getString("confirmPassword", "") ?: ""

        findViewById<TextView>(R.id.tvNama).text =
            "Nama: $nama"

        findViewById<TextView>(R.id.tvEmail).text =
            "Email: $email"

        findViewById<TextView>(R.id.tvTanggalLahir).text =
            "Tanggal lahir: $tanggal"

        findViewById<TextView>(R.id.tvGender).text =
            "Jenis kelamin: $gender"

        findViewById<TextView>(R.id.tvUsername).text =
            "Username: $username"

        findViewById<TextView>(R.id.tvPassword).text =
            "Password: " + "•".repeat(password.length)

        findViewById<TextView>(R.id.tvConfirmPassword).text =
            "Konfirmasi password: " + "•".repeat(confirm.length)

        // Kembali ke form registrasi tanpa menghapus isian
        findViewById<Button>(R.id.btnKembali).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            validasiDanSubmit(
                nama,
                email,
                tanggal,
                gender,
                username,
                password,
                confirm
            )
        }
    }

    private fun validasiDanSubmit(
        nama: String,
        email: String,
        tanggal: String,
        gender: String,
        username: String,
        password: String,
        confirm: String
    ) {
        val semuaTerisi = listOf(
            nama, email, tanggal, gender,
            username, password, confirm
        ).all { it.isNotBlank() }

        if (!semuaTerisi) {
            Toast.makeText(
                this,
                "Data belum lengkap. Silakan kembali.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(
                this,
                "Format email tidak valid.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (password != confirm) {
            Toast.makeText(
                this,
                "Password dan konfirmasi tidak sama.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        // Tandai akun sebagai sudah diverifikasi
        prefs.edit()
            .putBoolean("isVerified", true)
            .apply()

        AlertDialog.Builder(this)
            .setTitle("Registrasi Berhasil")
            .setMessage(
                "Data registrasi berhasil divalidasi."
            )
            .setPositiveButton("OK") { _, _ ->
                val intent = Intent(
                    this,
                    LoginActivity::class.java
                )

                intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
                )

                startActivity(intent)
                finish()
            }
            .setCancelable(false)
            .show()
    }
}

