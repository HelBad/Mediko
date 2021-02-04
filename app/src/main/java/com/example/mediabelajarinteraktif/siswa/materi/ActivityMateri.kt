package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.mediabelajarinteraktif.ExitScreen
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.siswa.ActivityUtama

class ActivityMateri : AppCompatActivity() {
    lateinit var menuMateri1: LinearLayout
    lateinit var menuMateri2: LinearLayout
    lateinit var menuMateri3: LinearLayout
    lateinit var homeMateri: ImageView
    lateinit var closeMateri: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        menuMateri1 = findViewById(R.id.menuMateri1)
        menuMateri2 = findViewById(R.id.menuMateri2)
        menuMateri3 = findViewById(R.id.menuMateri3)
        homeMateri = findViewById(R.id.homeMateri)
        closeMateri = findViewById(R.id.closeMateri)

        menuMateri1.setOnClickListener {
            val intent = Intent(this, ActivityApbn::class.java)
            startActivity(intent)
        }
        menuMateri2.setOnClickListener {
            val intent = Intent(this, ActivityApbd::class.java)
            startActivity(intent)
        }
        menuMateri3.setOnClickListener {
            val intent = Intent(this, ActivityVideo::class.java)
            startActivity(intent)
        }
        homeMateri.setOnClickListener {
            val intent = Intent(this, ActivityUtama::class.java)
            startActivity(intent)
        }
        closeMateri.setOnClickListener {
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