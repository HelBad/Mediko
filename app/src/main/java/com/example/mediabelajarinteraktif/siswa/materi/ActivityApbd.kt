package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.mediabelajarinteraktif.R

class ActivityApbd : AppCompatActivity() {
    lateinit var apbdPengertian: Button
    lateinit var apbdSumber: Button
    lateinit var apbdJenis: Button
    lateinit var apbdMekanisme: Button
    lateinit var materiApbd: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apbd)

        apbdPengertian = findViewById(R.id.apbdPengertian)
        apbdSumber = findViewById(R.id.apbdSumber)
        apbdJenis = findViewById(R.id.apbdJenis)
        apbdMekanisme = findViewById(R.id.apbdMekanisme)
        materiApbd = findViewById(R.id.materiApbd)

        apbdPengertian.setOnClickListener {
            val intent = Intent(this, ActivityPengertianapbd::class.java)
            startActivity(intent)
        }
        apbdSumber.setOnClickListener {
            val intent = Intent(this, ActivitySumberapbd::class.java)
            startActivity(intent)
        }
        apbdJenis.setOnClickListener {
            val intent = Intent(this, ActivityJenisapbd::class.java)
            startActivity(intent)
        }
        apbdMekanisme.setOnClickListener {
            val intent = Intent(this, ActivityMekanismeapbd::class.java)
            startActivity(intent)
        }
        materiApbd.setOnClickListener {
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