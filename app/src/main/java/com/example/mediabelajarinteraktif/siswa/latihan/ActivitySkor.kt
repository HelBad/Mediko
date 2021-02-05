package com.example.mediabelajarinteraktif

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.mediabelajarinteraktif.model.Soal
import com.example.mediabelajarinteraktif.model.Status
import com.example.mediabelajarinteraktif.siswa.ActivityUtama
import com.example.mediabelajarinteraktif.siswa.latihan.ActivityLatihan
import kotlinx.android.synthetic.main.activity_skor.*
import kotlinx.android.synthetic.main.activity_skor.btnSubmit
import kotlinx.android.synthetic.main.activity_soal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivitySkor : AppCompatActivity() {

    private lateinit var nama : String
    private lateinit var noAbsen : String
    private lateinit var kelas : String
    private var benar : Int = 0
    private var salah : Int = 0
    private var nilai : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skor)

        nama = intent.getStringExtra("nama")
        noAbsen = intent.getStringExtra("no_absen")
        kelas = intent.getStringExtra("kelas")
        benar = intent.getIntExtra("benar", 0)
        salah = intent.getIntExtra("salah", 0)
        nilai = intent.getIntExtra("nilai", 0)

        textNama.text = "Nama: ${nama}"
        textNoAbsen.text = "No Absen: ${noAbsen}"
        textKelas.text = "Kelas: ${kelas}"
        textCorrect.text = "Correct questions: ${benar}"
        textIncorrect.text = "Inorrect questions: ${salah}"
        textFinalScore.text = "Final Score: ${nilai}"
        textLulus.text = if(nilai < 75) "TIDAK LULUS" else "LULUS"

        btnTryAgain.setOnClickListener {
            val intent = Intent(this, ActivityLatihan::class.java)
            startActivity(intent)
        }

        btnSubmit.setOnClickListener {
            val sharedPref = getSharedPreferences("auth", Context.MODE_PRIVATE)
            val id = sharedPref.getInt("id", 0)

            ApiClient().getService()
                .submitNilai(id, nilai, nama, noAbsen, kelas)
                .enqueue(object : Callback<Status> {
                    override fun onResponse(call: Call<Status>, response: Response<Status>) {
                        if(response.code() == 200) {
                            response.body().let {
                                if(it?.status == "success"){
                                    val intent = Intent(this@ActivitySkor, ActivityUtama::class.java)
                                    startActivity(intent)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<Status>, t: Throwable) {
                        t.message?.let { Log.d("API: ", it) }
                    }
                })
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}
