package com.example.mediabelajarinteraktif.siswa.materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.mediabelajarinteraktif.R

class ActivitySumberapbd : AppCompatActivity() {
    lateinit var scrollSumberapbd: ScrollView
    lateinit var scrollupSumberapbd: Button
    lateinit var scrolldownSumberapbd: Button
    lateinit var sumberapbdPengertian: LinearLayout
    lateinit var sumberapbdJenis: LinearLayout
    lateinit var sumberapbdMekanisme: LinearLayout
    lateinit var sumberapbdMateri: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sumberapbd)

        scrollSumberapbd = findViewById(R.id.scrollSumberapbd)
        scrollupSumberapbd = findViewById(R.id.scrollupSumberapbd)
        scrolldownSumberapbd = findViewById(R.id.scrolldownSumberapbd)
        sumberapbdPengertian = findViewById(R.id.sumberapbdPengertian)
        sumberapbdJenis = findViewById(R.id.sumberapbdJenis)
        sumberapbdMekanisme = findViewById(R.id.sumberapbdMekanisme)
        sumberapbdMateri = findViewById(R.id.sumberapbdMateri)

        sumberapbdPengertian.setOnClickListener {
            val intent = Intent(this, ActivityPengertianapbd::class.java)
            startActivity(intent)
        }
        sumberapbdJenis.setOnClickListener {
            val intent = Intent(this, ActivityJenisapbd::class.java)
            startActivity(intent)
        }
        sumberapbdMekanisme.setOnClickListener {
            val intent = Intent(this, ActivityMekanismeapbd::class.java)
            startActivity(intent)
        }
        sumberapbdMateri.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
        }

        scrollupSumberapbd.setOnClickListener {
            scrollSumberapbd.arrowScroll(ScrollView.FOCUS_UP)
        }
        scrolldownSumberapbd.setOnClickListener {
            scrollSumberapbd.arrowScroll(ScrollView.FOCUS_DOWN)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}