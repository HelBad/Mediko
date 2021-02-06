package com.example.mediabelajarinteraktif.siswa.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.siswa.ActivityUtama
import kotlinx.android.synthetic.main.activity_latihan.*

class ActivityLatihan : AppCompatActivity() {
    lateinit var btnStart: Button
    lateinit var homeLatihan: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan)

        btnStart = findViewById(R.id.btnStart)
        homeLatihan = findViewById(R.id.homeLatihan)

        btnStart.setOnClickListener {
            if(textNama.text.toString().isEmpty() || textNomor.text.toString().isEmpty() || textKelas.text.toString().isEmpty()) {
                Toast.makeText(this, "Data Empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ActivitySoal::class.java)
                intent.putExtra("nama", textNama.text.toString())
                intent.putExtra("no_absen", textNomor.text.toString())
                intent.putExtra("kelas", textKelas.text.toString())
                startActivity(intent)
            }
        }

        homeLatihan.setOnClickListener {
            val intent = Intent(this, ActivityUtama::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}