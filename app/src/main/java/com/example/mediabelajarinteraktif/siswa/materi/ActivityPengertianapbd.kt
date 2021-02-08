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

class ActivityPengertianapbd : AppCompatActivity() {
    lateinit var scrollPengertianapbd: ScrollView
    lateinit var scrollupPengertianapbd: Button
    lateinit var scrolldownPengertianapbd: Button
    lateinit var pengertianapbdSumber: LinearLayout
    lateinit var pengertianapbdJenis: LinearLayout
    lateinit var pengertianapbdMekanisme: LinearLayout
    lateinit var pengertianapbdMateri: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengertianapbd)

        scrollPengertianapbd = findViewById(R.id.scrollPengertianapbd)
        scrollupPengertianapbd = findViewById(R.id.scrollupPengertianapbd)
        scrolldownPengertianapbd = findViewById(R.id.scrolldownPengertianapbd)
        pengertianapbdSumber = findViewById(R.id.pengertianapbdSumber)
        pengertianapbdJenis = findViewById(R.id.pengertianapbdJenis)
        pengertianapbdMekanisme = findViewById(R.id.pengertianapbdMekanisme)
        pengertianapbdMateri = findViewById(R.id.pengertianapbdMateri)

        pengertianapbdSumber.setOnClickListener {
            val intent = Intent(this, ActivitySumberapbd::class.java)
            startActivity(intent)
            finish()
        }
        pengertianapbdJenis.setOnClickListener {
            val intent = Intent(this, ActivityJenisapbd::class.java)
            startActivity(intent)
            finish()
        }
        pengertianapbdMekanisme.setOnClickListener {
            val intent = Intent(this, ActivityMekanismeapbd::class.java)
            startActivity(intent)
            finish()
        }
        pengertianapbdMateri.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
            finish()
        }

        scrollupPengertianapbd.setOnClickListener {
            scrollPengertianapbd.arrowScroll(ScrollView.FOCUS_UP)
        }
        scrolldownPengertianapbd.setOnClickListener {
            scrollPengertianapbd.arrowScroll(ScrollView.FOCUS_DOWN)
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