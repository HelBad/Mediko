package com.example.mediabelajarinteraktif.siswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_soal.*

class ActivitySoal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)

        btnSubmit.setOnClickListener {
            val intent = Intent(this, ActivitySkor::class.java)
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
