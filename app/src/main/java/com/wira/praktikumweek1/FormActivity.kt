package com.wira.praktikumweek1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val tvSender = findViewById<TextView>(R.id.tvSender)
        val sender = intent.getStringExtra("EXTRA_SENDER")
        tvSender.text = "Halo, $sender!"
    }
}