package com.example.mediabelajarinteraktif.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.mediabelajarinteraktif.ExitScreen
import com.example.mediabelajarinteraktif.R

class ActivityNilai : AppCompatActivity() {
    lateinit var soalNilaiGuru: ImageView
    lateinit var closeNilaiGuru: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai_guru)

        soalNilaiGuru = findViewById(R.id.soalNilaiGuru)
        closeNilaiGuru = findViewById(R.id.closeNilaiGuru)

        soalNilaiGuru.setOnClickListener {
            val intent = Intent(this, ActivitySoal::class.java)
            startActivity(intent)
        }
        closeNilaiGuru.setOnClickListener {
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