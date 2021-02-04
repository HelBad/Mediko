package com.example.mediabelajarinteraktif

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mediabelajarinteraktif.siswa.ActivityUtama
import com.example.mediabelajarinteraktif.siswa.latihan.ActivityLatihan
import kotlinx.android.synthetic.main.activity_skor.*

class ActivitySkor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skor)

        btnTryAgain.setOnClickListener {
            val intent = Intent(this, ActivityLatihan::class.java)
            startActivity(intent)
        }

        btnSubmit.setOnClickListener {
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