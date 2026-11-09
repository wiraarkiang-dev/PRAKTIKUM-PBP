package com.wira.praktikumweek1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etUsia = findViewById<EditText>(R.id.etUsia)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnForm = findViewById<Button>(R.id.btnForm)
        val btnBrowser = findViewById<Button>(R.id.btnBrowser)

        btnToast.setOnClickListener {
            Toast.makeText(this, "Toast button clicked successfully!", Toast.LENGTH_SHORT).show()
        }

        // Explicit Intent with validation
        btnForm.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val usiaText = etUsia.text.toString().trim()
            val usia = usiaText.toIntOrNull()

            if (nama.isEmpty() || usiaText.isEmpty()) {
                // nama atau usia kosong -> error + Toast
                if (nama.isEmpty()) {
                    etNama.error = "Name is required!"
                }
                if (usiaText.isEmpty()) {
                    etUsia.error = "Age is required!"
                }
                Toast.makeText(this, "Please fill in your name and age first!", Toast.LENGTH_SHORT).show()
            } else if (usia == null || usia < 0) {
                // tantangan: usia tidak boleh minus (usia < 0)
                etUsia.error = "Age must not be negative!"
                Toast.makeText(this, "Age must be a valid number and not negative!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, FormActivity::class.java)
                intent.putExtra("EXTRA_NAMA", nama)
                intent.putExtra("EXTRA_USIA", usia)
                startActivity(intent)
            }
        }

        // Implicit Intent (Open URL External Browser)
        btnBrowser.setOnClickListener {
            val query = "https://akprind.ac.id"
            val intent = Intent(Intent.ACTION_VIEW, query.toUri())
            startActivity(intent)
        }
    }
}