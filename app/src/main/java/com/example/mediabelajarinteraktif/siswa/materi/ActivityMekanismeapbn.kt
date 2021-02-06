package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.mediabelajarinteraktif.R

class ActivityMekanismeapbn : AppCompatActivity() {
    lateinit var scrollMekanismeapbn: ScrollView
    lateinit var scrollupMekanismeapbn: Button
    lateinit var scrolldownMekanismeapbn: Button
    lateinit var mekanismeapbnPengertian: LinearLayout
    lateinit var mekanismeapbnSumber: LinearLayout
    lateinit var mekanismeapbnJenis: LinearLayout
    lateinit var mekanismeapbnMateri: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mekanismeapbn)

        scrollMekanismeapbn = findViewById(R.id.scrollMekanismeapbn)
        scrollupMekanismeapbn = findViewById(R.id.scrollupMekanismeapbn)
        scrolldownMekanismeapbn = findViewById(R.id.scrolldownMekanismeapbn)
        mekanismeapbnPengertian = findViewById(R.id.mekanismeapbnPengertian)
        mekanismeapbnSumber = findViewById(R.id.mekanismeapbnSumber)
        mekanismeapbnJenis = findViewById(R.id.mekanismeapbnJenis)
        mekanismeapbnMateri = findViewById(R.id.mekanismeapbnMateri)

        mekanismeapbnPengertian.setOnClickListener {
            val intent = Intent(this, ActivityPengertianapbn::class.java)
            startActivity(intent)
        }
        mekanismeapbnSumber.setOnClickListener {
            val intent = Intent(this, ActivitySumberapbn::class.java)
            startActivity(intent)
        }
        mekanismeapbnJenis.setOnClickListener {
            val intent = Intent(this, ActivityJenisapbn::class.java)
            startActivity(intent)
        }
        mekanismeapbnMateri.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
        }

        scrollupMekanismeapbn.setOnClickListener {
            scrollMekanismeapbn.arrowScroll(ScrollView.FOCUS_UP)
        }
        scrolldownMekanismeapbn.setOnClickListener {
            scrollMekanismeapbn.arrowScroll(ScrollView.FOCUS_DOWN)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}