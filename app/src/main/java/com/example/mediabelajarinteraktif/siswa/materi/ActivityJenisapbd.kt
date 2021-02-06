package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.mediabelajarinteraktif.R

class ActivityJenisapbd : AppCompatActivity() {
    lateinit var scrollJenisapbd: ScrollView
    lateinit var scrollupJenisapbd: Button
    lateinit var scrolldownJenisapbd: Button
    lateinit var jenisapbdPengertian: LinearLayout
    lateinit var jenisapbdSumber: LinearLayout
    lateinit var jenisapbdMekanisme: LinearLayout
    lateinit var jenisapbdMateri: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jenisapbd)

        scrollJenisapbd = findViewById(R.id.scrollJenisapbd)
        scrollupJenisapbd = findViewById(R.id.scrollupJenisapbd)
        scrolldownJenisapbd = findViewById(R.id.scrolldownJenisapbd)
        jenisapbdPengertian = findViewById(R.id.jenisapbdPengertian)
        jenisapbdSumber = findViewById(R.id.jenisapbdSumber)
        jenisapbdMekanisme = findViewById(R.id.jenisapbdMekanisme)
        jenisapbdMateri = findViewById(R.id.jenisapbdMateri)

        jenisapbdPengertian.setOnClickListener {
            val intent = Intent(this, ActivityPengertianapbd::class.java)
            startActivity(intent)
        }
        jenisapbdSumber.setOnClickListener {
            val intent = Intent(this, ActivitySumberapbd::class.java)
            startActivity(intent)
        }
        jenisapbdMekanisme.setOnClickListener {
            val intent = Intent(this, ActivityMekanismeapbd::class.java)
            startActivity(intent)
        }
        jenisapbdMateri.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
        }

        scrollupJenisapbd.setOnClickListener {
            scrollJenisapbd.arrowScroll(ScrollView.FOCUS_UP)
        }
        scrolldownJenisapbd.setOnClickListener {
            scrollJenisapbd.arrowScroll(ScrollView.FOCUS_DOWN)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}