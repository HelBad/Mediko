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

class ActivityMekanismeapbd : AppCompatActivity() {
    lateinit var scrollMekanismeapbd: ScrollView
    lateinit var scrollupMekanismeapbd: Button
    lateinit var scrolldownMekanismeapbd: Button
    lateinit var mekanismeapbdPengertian: LinearLayout
    lateinit var mekanismeapbdSumber: LinearLayout
    lateinit var mekanismeapbdJenis: LinearLayout
    lateinit var mekanismeapbdMateri: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mekanismeapbd)

        scrollMekanismeapbd = findViewById(R.id.scrollMekanismeapbd)
        scrollupMekanismeapbd = findViewById(R.id.scrollupMekanismeapbd)
        scrolldownMekanismeapbd = findViewById(R.id.scrolldownMekanismeapbd)
        mekanismeapbdPengertian = findViewById(R.id.mekanismeapbdPengertian)
        mekanismeapbdSumber = findViewById(R.id.mekanismeapbdSumber)
        mekanismeapbdJenis = findViewById(R.id.mekanismeapbdJenis)
        mekanismeapbdMateri = findViewById(R.id.mekanismeapbdMateri)

        mekanismeapbdPengertian.setOnClickListener {
            val intent = Intent(this, ActivityPengertianapbd::class.java)
            startActivity(intent)
            finish()
        }
        mekanismeapbdSumber.setOnClickListener {
            val intent = Intent(this, ActivitySumberapbd::class.java)
            startActivity(intent)
            finish()
        }
        mekanismeapbdJenis.setOnClickListener {
            val intent = Intent(this, ActivityJenisapbd::class.java)
            startActivity(intent)
            finish()
        }
        mekanismeapbdMateri.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
            finish()
        }

        scrollupMekanismeapbd.setOnClickListener {
            scrollMekanismeapbd.arrowScroll(ScrollView.FOCUS_UP)
        }
        scrolldownMekanismeapbd.setOnClickListener {
            scrollMekanismeapbd.arrowScroll(ScrollView.FOCUS_DOWN)
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