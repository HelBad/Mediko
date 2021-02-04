package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.mediabelajarinteraktif.R

class ActivityJenisapbn : AppCompatActivity() {
    lateinit var scrollJenisapbn: ScrollView
    lateinit var scrollupJenisapbn: Button
    lateinit var scrolldownJenisapbn: Button
    lateinit var jenisapbnPengertian: LinearLayout
    lateinit var jenisapbnSumber: LinearLayout
    lateinit var jenisapbnMekanisme: LinearLayout
    lateinit var jenisapbnMateri: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jenisapbn)

        scrollJenisapbn = findViewById(R.id.scrollJenisapbn)
        scrollupJenisapbn = findViewById(R.id.scrollupJenisapbn)
        scrolldownJenisapbn = findViewById(R.id.scrolldownJenisapbn)
        jenisapbnPengertian = findViewById(R.id.jenisapbnPengertian)
        jenisapbnSumber = findViewById(R.id.jenisapbnSumber)
        jenisapbnMekanisme = findViewById(R.id.jenisapbnMekanisme)
        jenisapbnMateri = findViewById(R.id.jenisapbnMateri)

        jenisapbnPengertian.setOnClickListener {
            val intent = Intent(this, ActivityPengertianapbn::class.java)
            startActivity(intent)
        }
        jenisapbnSumber.setOnClickListener {
            val intent = Intent(this, ActivitySumberapbn::class.java)
            startActivity(intent)
        }
        jenisapbnMekanisme.setOnClickListener {
            val intent = Intent(this, ActivityMekanismeapbn::class.java)
            startActivity(intent)
        }
        jenisapbnMateri.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
        }

        scrollupJenisapbn.setOnClickListener {
            scrollJenisapbn.arrowScroll(ScrollView.FOCUS_UP)
        }
        scrolldownJenisapbn.setOnClickListener {
            scrollJenisapbn.arrowScroll(ScrollView.FOCUS_DOWN)
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