package com.example.mediabelajarinteraktif

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_skor.*

class ActivitySkor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skor)

        btnSubmit.setOnClickListener {
            val intent = Intent(this, ActivitySkor::class.java)
            startActivity(intent)
        }
    }
}