package com.example.mediabelajarinteraktif

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

class ActivityProfil : AppCompatActivity() {
    lateinit var homeProfil: ImageView
    lateinit var closeProfil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        homeProfil = findViewById(R.id.homeProfil)
        closeProfil = findViewById(R.id.closeProfil)

        homeProfil.setOnClickListener {
            val intent = Intent(this, ActivityUtama::class.java)
            startActivity(intent)
        }
        closeProfil.setOnClickListener {
            val intent = Intent(this, ActivityKeluar::class.java)
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