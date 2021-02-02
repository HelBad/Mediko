package com.example.mediabelajarinteraktif.siswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.mediabelajarinteraktif.ExitScreen
import com.example.mediabelajarinteraktif.R

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