package com.example.mediabelajarinteraktif.guru

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediabelajarinteraktif.ApiClient
import com.example.mediabelajarinteraktif.ExitScreen
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.model.User
import kotlinx.android.synthetic.main.activity_nilai_guru.*
import kotlinx.android.synthetic.main.screen_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityNilai : AppCompatActivity() {
    lateinit var soalNilaiGuru: ImageView
    lateinit var closeNilaiGuru: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai_guru)

        soalNilaiGuru = findViewById(R.id.soalNilaiGuru)
        closeNilaiGuru = findViewById(R.id.closeNilaiGuru)

        soalNilaiGuru.setOnClickListener {
            val intent = Intent(this, ActivitySoal::class.java)
            startActivity(intent)
        }
        closeNilaiGuru.setOnClickListener {
            val intent = Intent(this, ExitScreen::class.java)
            startActivity(intent)
        }

        ApiClient().getService()
            .getNilai()
            .enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if(response.code() == 200) {
                        response.body().let {
                            if(it != null) {
                                loading.visibility = View.GONE
                                rvNilai.setHasFixedSize(true)
                                rvNilai.layoutManager = LinearLayoutManager(this@ActivityNilai)
                                val adapter = AdapterNilai(it as ArrayList<User>)
                                adapter.notifyDataSetChanged()
                                rvNilai.adapter = adapter
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    t.message?.let { Log.d("API: ", it) }
                }
            })
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}