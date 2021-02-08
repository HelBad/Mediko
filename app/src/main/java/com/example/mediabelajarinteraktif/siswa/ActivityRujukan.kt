package com.example.mediabelajarinteraktif.siswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.mediabelajarinteraktif.ExitScreen
import com.example.mediabelajarinteraktif.R

class ActivityRujukan : AppCompatActivity() {
    lateinit var homeRujukan: ImageView
    lateinit var closeRujukan: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rujukan)

        homeRujukan = findViewById(R.id.homeRujukan)
        closeRujukan = findViewById(R.id.closeRujukan)

        homeRujukan.setOnClickListener {
            val intent = Intent(this, ActivityUtama::class.java)
            startActivity(intent)
            finish()
        }
        closeRujukan.setOnClickListener {
            val intent = Intent(this, ExitScreen::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onBackPressed() {
        val intent = Intent(this, ActivityUtama::class.java)
        startActivity(intent)
        finish()
    }
}