package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import com.example.mediabelajarinteraktif.R

class ActivitySumberapbn : AppCompatActivity() {
    lateinit var scrollSumberapbn: ScrollView
    lateinit var scrollupSumberapbn: Button
    lateinit var scrolldownSumberapbn: Button
    lateinit var sumberapbnPengertian: LinearLayout
    lateinit var sumberapbnJenis: LinearLayout
    lateinit var sumberapbnMekanisme: LinearLayout
    lateinit var sumberapbnMateri: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sumberapbn)

        scrollSumberapbn = findViewById(R.id.scrollSumberapbn)
        scrollupSumberapbn = findViewById(R.id.scrollupSumberapbn)
        scrolldownSumberapbn = findViewById(R.id.scrolldownSumberapbn)
        sumberapbnPengertian = findViewById(R.id.sumberapbnPengertian)
        sumberapbnJenis = findViewById(R.id.sumberapbnJenis)
        sumberapbnMekanisme = findViewById(R.id.sumberapbnMekanisme)
        sumberapbnMateri = findViewById(R.id.sumberapbnMateri)

        sumberapbnPengertian.setOnClickListener {
            val intent = Intent(this, ActivityPengertianapbn::class.java)
            startActivity(intent)
            finish()
        }
        sumberapbnJenis.setOnClickListener {
            val intent = Intent(this, ActivityJenisapbn::class.java)
            startActivity(intent)
            finish()
        }
        sumberapbnMekanisme.setOnClickListener {
            val intent = Intent(this, ActivityMekanismeapbn::class.java)
            startActivity(intent)
            finish()
        }
        sumberapbnMateri.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
            finish()
        }

        scrollupSumberapbn.setOnClickListener {
            scrollSumberapbn.arrowScroll(ScrollView.FOCUS_UP)
        }
        scrolldownSumberapbn.setOnClickListener {
            scrollSumberapbn.arrowScroll(ScrollView.FOCUS_DOWN)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onBackPressed() {
        val intent = Intent(this, ActivityMateri::class.java)
        startActivity(intent)
        finish()
    }
}