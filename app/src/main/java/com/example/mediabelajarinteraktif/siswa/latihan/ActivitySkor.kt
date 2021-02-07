package com.example.mediabelajarinteraktif.siswa.latihan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.api.ApiClient
import com.example.mediabelajarinteraktif.model.Pilihan
import com.example.mediabelajarinteraktif.model.Soal
import com.example.mediabelajarinteraktif.model.Status
import com.example.mediabelajarinteraktif.siswa.ActivityUtama
import kotlinx.android.synthetic.main.activity_skor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class ActivitySkor : AppCompatActivity() {
    private lateinit var nama : String
    private lateinit var noAbsen : String
    private lateinit var kelas : String
    private var time : Long = 0L
    private var benar : Int = 0
    private var salah : Int = 0
    private var nilai : Int = 0
    private var minutes = 0L
    private var seconds = 0L
    private var soal : ArrayList<Soal> = ArrayList()
    private var jawaban : HashMap<Int, Pilihan> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skor)

        nama = intent.getStringExtra("nama")
        noAbsen = intent.getStringExtra("no_absen")
        kelas = intent.getStringExtra("kelas")
        time = intent.getLongExtra("time", 0L)
        benar = intent.getIntExtra("benar", 0)
        salah = intent.getIntExtra("salah", 0)
        nilai = intent.getIntExtra("nilai", 0)
        soal = intent.getSerializableExtra( "soal") as ArrayList<Soal>
        jawaban = intent.getSerializableExtra( "jawaban") as HashMap<Int, Pilihan>

        if(time > 60000) {
            minutes = TimeUnit.MILLISECONDS.toMinutes(time)
            seconds = TimeUnit.MILLISECONDS.toSeconds(time)-(TimeUnit.MILLISECONDS.toMinutes(time)*60)
        }
        else {
            seconds = TimeUnit.MILLISECONDS.toSeconds(time)
        }

        textNama.text = "${nama}"
        textNoAbsen.text = "${noAbsen}"
        textKelas.text = "${kelas}"
        textCorrect.text = "${benar}"
        textIncorrect.text = "${salah}"
        textFinalScore.text = "${nilai}"
        if(time > 60000) textTime.text = "${minutes} menit ${seconds} detik"
        else textTime.text = "${seconds} detik"
        textLulus.text = if(nilai < 75) "TIDAK LULUS" else "LULUS"

        rvPembahasan.setHasFixedSize(true)
        rvPembahasan.layoutManager = LinearLayoutManager(this@ActivitySkor)
        val adapter = AdapterSkor(soal, jawaban)
        adapter.notifyDataSetChanged()
        loading.visibility = View.GONE
        rvPembahasan.adapter = adapter

        btnTryAgain.setOnClickListener {
            val intent = Intent(this, ActivityLatihan::class.java)
            startActivity(intent)
        }
        btnSubmit.setOnClickListener {
            val sharedPref = getSharedPreferences("auth", Context.MODE_PRIVATE)
            val id = sharedPref.getInt("id", 0)
            ApiClient().getService().submitNilai(id, nilai, nama, noAbsen, kelas).enqueue(object : Callback<Status> {
                override fun onResponse(call: Call<Status>, response: Response<Status>) {
                    if (response.code() == 200) {
                        response.body().let {
                            if (it?.status == "success") {
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
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}