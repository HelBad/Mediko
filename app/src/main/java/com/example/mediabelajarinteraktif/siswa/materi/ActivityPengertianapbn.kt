package com.example.mediabelajarinteraktif.siswa.materi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.mediabelajarinteraktif.R

class ActivityPengertianapbn : AppCompatActivity() {
//    lateinit var menuMateri1: LinearLayout
//    lateinit var menuMateri2: LinearLayout
//    lateinit var menuMateri3: LinearLayout
//    lateinit var homeMateri: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengertianapbn)

//        menuMateri1 = findViewById(R.id.menuMateri1)
//        menuMateri2 = findViewById(R.id.menuMateri2)
//        menuMateri3 = findViewById(R.id.menuMateri3)
//        homeMateri = findViewById(R.id.homeMateri)
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}