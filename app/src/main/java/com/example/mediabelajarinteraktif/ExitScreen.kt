package com.example.mediabelajarinteraktif

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ExitScreen : AppCompatActivity() {
    lateinit var btnYes: Button
    lateinit var btnNo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_exit)

        btnYes = findViewById(R.id.btnYes)
        btnNo = findViewById(R.id.btnNo)

        btnYes.setOnClickListener {
            finishAffinity()
        }
        btnNo.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}