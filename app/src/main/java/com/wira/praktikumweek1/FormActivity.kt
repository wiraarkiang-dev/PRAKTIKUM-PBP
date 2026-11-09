package com.wira.praktikumweek1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val etInputMessage = findViewById<EditText>(R.id.etInputMessage)
        val btnSend = findViewById<Button>(R.id.btnSend)

        // Get data (String) from Explicit Intent (MainActivity)
        val nameSender = intent.getStringExtra("EXTRA_SENDER")

        tvWelcome.text = getString(R.string.welcome, nameSender)

        btnSend.setOnClickListener {
            val message = etInputMessage.text.toString().trim()
            if (message.isNotEmpty()) {
                Toast.makeText(
                    this, "Message save: $message",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            } else {
                etInputMessage.error = "Message cannot be empty!"
            }
        }
    }
}