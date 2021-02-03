package com.example.mediabelajarinteraktif.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.mediabelajarinteraktif.ExitScreen
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.siswa.ActivityUtama

class ActivitySoal : AppCompatActivity() {
    lateinit var nilaiSoalGuru: ImageView
    lateinit var closeSoalGuru: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal_guru)

        nilaiSoalGuru = findViewById(R.id.nilaiSoalGuru)
        closeSoalGuru = findViewById(R.id.closeSoalGuru)

        nilaiSoalGuru.setOnClickListener {
            val intent = Intent(this, ActivityNilai::class.java)
            startActivity(intent)
        }
        closeSoalGuru.setOnClickListener {
            val intent = Intent(this, ExitScreen::class.java)
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