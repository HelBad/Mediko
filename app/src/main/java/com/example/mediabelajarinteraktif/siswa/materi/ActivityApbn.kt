package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.mediabelajarinteraktif.R

class ActivityApbn : AppCompatActivity() {
    lateinit var apbnPengertian: Button
    lateinit var apbnSumber: Button
    lateinit var apbnJenis: Button
    lateinit var apbnMekanisme: Button
    lateinit var materiApbn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apbn)

        apbnPengertian = findViewById(R.id.apbnPengertian)
        apbnSumber = findViewById(R.id.apbnSumber)
        apbnJenis = findViewById(R.id.apbnJenis)
        apbnMekanisme = findViewById(R.id.apbnMekanisme)
        materiApbn = findViewById(R.id.materiApbn)

        apbnPengertian.setOnClickListener {
            val intent = Intent(this, ActivityPengertianapbn::class.java)
            startActivity(intent)
        }
        apbnSumber.setOnClickListener {
            val intent = Intent(this, ActivitySumberapbn::class.java)
            startActivity(intent)
        }
        apbnJenis.setOnClickListener {
            val intent = Intent(this, ActivityJenisapbn::class.java)
            startActivity(intent)
        }
        apbnMekanisme.setOnClickListener {
            val intent = Intent(this, ActivityMekanismeapbn::class.java)
            startActivity(intent)
        }
        materiApbn.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
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