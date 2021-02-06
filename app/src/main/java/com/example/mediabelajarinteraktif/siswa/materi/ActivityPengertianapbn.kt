package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.mediabelajarinteraktif.R

class ActivityPengertianapbn : AppCompatActivity() {
    lateinit var scrollPengertianapbn: ScrollView
    lateinit var scrollupPengertianapbn: Button
    lateinit var scrolldownPengertianapbn: Button
    lateinit var pengertianapbnSumber: LinearLayout
    lateinit var pengertianapbnJenis: LinearLayout
    lateinit var pengertianapbnMekanisme: LinearLayout
    lateinit var pengertianapbnMateri: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengertianapbn)

        scrollPengertianapbn = findViewById(R.id.scrollPengertianapbn)
        scrollupPengertianapbn = findViewById(R.id.scrollupPengertianapbn)
        scrolldownPengertianapbn = findViewById(R.id.scrolldownPengertianapbn)
        pengertianapbnSumber = findViewById(R.id.pengertianapbnSumber)
        pengertianapbnJenis = findViewById(R.id.pengertianapbnJenis)
        pengertianapbnMekanisme = findViewById(R.id.pengertianapbnMekanisme)
        pengertianapbnMateri = findViewById(R.id.pengertianapbnMateri)

        pengertianapbnSumber.setOnClickListener {
            val intent = Intent(this, ActivitySumberapbn::class.java)
            startActivity(intent)
        }
        pengertianapbnJenis.setOnClickListener {
            val intent = Intent(this, ActivityJenisapbn::class.java)
            startActivity(intent)
        }
        pengertianapbnMekanisme.setOnClickListener {
            val intent = Intent(this, ActivityMekanismeapbn::class.java)
            startActivity(intent)
        }
        pengertianapbnMateri.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
        }

        scrollupPengertianapbn.setOnClickListener {
            scrollPengertianapbn.arrowScroll(ScrollView.FOCUS_UP)
        }
        scrolldownPengertianapbn.setOnClickListener {
            scrollPengertianapbn.arrowScroll(ScrollView.FOCUS_DOWN)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}