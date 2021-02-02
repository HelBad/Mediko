package com.example.mediabelajarinteraktif.siswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.mediabelajarinteraktif.R

class ActivityLatihan : AppCompatActivity() {
    lateinit var btnStart: Button
    lateinit var homeLatihan: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan)

        btnStart = findViewById(R.id.btnStart)
        homeLatihan = findViewById(R.id.homeLatihan)

        btnStart.setOnClickListener {
            val intent = Intent(this, ActivitySoal::class.java)
            startActivity(intent)
        }
        homeLatihan.setOnClickListener {
            val intent = Intent(this, ActivityUtama::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}