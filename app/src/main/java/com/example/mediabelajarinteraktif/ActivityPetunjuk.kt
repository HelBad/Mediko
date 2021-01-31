package com.example.mediabelajarinteraktif

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

class ActivityPetunjuk : AppCompatActivity() {
    lateinit var homePetunjuk: ImageView
    lateinit var closePetunjuk: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petunjuk)

        homePetunjuk = findViewById(R.id.homePetunjuk)
        closePetunjuk = findViewById(R.id.closePetunjuk)

        homePetunjuk.setOnClickListener {
            val intent = Intent(this, ActivityUtama::class.java)
            startActivity(intent)
        }
        closePetunjuk.setOnClickListener {
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