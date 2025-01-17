package com.example.mediabelajarinteraktif.siswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.mediabelajarinteraktif.ExitScreen
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.siswa.latihan.ActivityLatihan
import com.example.mediabelajarinteraktif.siswa.materi.ActivityMateri

class ActivityUtama : AppCompatActivity() {
    lateinit var menuHome1: LinearLayout
    lateinit var menuHome2: LinearLayout
    lateinit var menuHome3: LinearLayout
    lateinit var menuHome4: LinearLayout
    lateinit var menuHome5: LinearLayout
    lateinit var menuHome6: LinearLayout
    lateinit var menuHome7: LinearLayout
    lateinit var menuHome8: LinearLayout
    lateinit var closeUtama: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utama)

        menuHome1 = findViewById(R.id.menuHome1)
        menuHome2 = findViewById(R.id.menuHome2)
        menuHome3 = findViewById(R.id.menuHome3)
        menuHome4 = findViewById(R.id.menuHome4)
        menuHome5 = findViewById(R.id.menuHome5)
        menuHome6 = findViewById(R.id.menuHome6)
        menuHome7 = findViewById(R.id.menuHome7)
        menuHome8 = findViewById(R.id.menuHome8)
        closeUtama = findViewById(R.id.closeUtama)

        menuHome1.setOnClickListener {
            val intent = Intent(this, ActivityPetunjuk::class.java)
            startActivity(intent)
            finish()
        }
        menuHome2.setOnClickListener {
            val intent = Intent(this, ActivityIndikator::class.java)
            startActivity(intent)
            finish()
        }
        menuHome3.setOnClickListener {
            val intent = Intent(this, ActivityPetakonsep::class.java)
            startActivity(intent)
            finish()
        }
        menuHome4.setOnClickListener {
            val intent = Intent(this, ActivityMateri::class.java)
            startActivity(intent)
            finish()
        }
        menuHome5.setOnClickListener {
            val intent = Intent(this, ActivityLatihan::class.java)
            startActivity(intent)
            finish()
        }
        menuHome6.setOnClickListener {
            val intent = Intent(this, ActivityGlosarium::class.java)
            startActivity(intent)
            finish()
        }
        menuHome7.setOnClickListener {
            val intent = Intent(this, ActivityRujukan::class.java)
            startActivity(intent)
            finish()
        }
        menuHome8.setOnClickListener {
            val intent = Intent(this, ActivityProfil::class.java)
            startActivity(intent)
            finish()
        }
        closeUtama.setOnClickListener {
            val intent = Intent(this, ExitScreen::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onBackPressed() {}
}