package com.example.mediabelajarinteraktif

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mediabelajarinteraktif.guru.ActivitySoal
import com.example.mediabelajarinteraktif.siswa.ActivityUtama

class WelcomeScreen : AppCompatActivity() {
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_welcome)

        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            val sharedPref = getSharedPreferences("auth", Context.MODE_PRIVATE)
            val id = sharedPref.getInt("id", 0)

            if(id == 0){
                val intent = Intent(this, LoginScreen::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, ActivityUtama::class.java)
                startActivity(intent)
            }
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