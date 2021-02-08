package com.example.mediabelajarinteraktif.siswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.mediabelajarinteraktif.ExitScreen
import com.example.mediabelajarinteraktif.R

class ActivityIndikator : AppCompatActivity() {
    lateinit var homeIndikator: ImageView
    lateinit var closeIndikator: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indikator)

        homeIndikator = findViewById(R.id.homeIndikator)
        closeIndikator = findViewById(R.id.closeIndikator)

        homeIndikator.setOnClickListener {
            val intent = Intent(this, ActivityUtama::class.java)
            startActivity(intent)
            finish()
        }
        closeIndikator.setOnClickListener {
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