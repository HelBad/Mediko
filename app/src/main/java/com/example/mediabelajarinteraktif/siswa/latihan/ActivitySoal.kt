package com.example.mediabelajarinteraktif.siswa.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mediabelajarinteraktif.R

class ActivitySoal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}