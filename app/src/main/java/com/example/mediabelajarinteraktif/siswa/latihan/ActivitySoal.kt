package com.example.mediabelajarinteraktif.siswa.latihan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.mediabelajarinteraktif.siswa.latihan.ActivitySkor
import com.example.mediabelajarinteraktif.ApiClient
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.model.Soal
import com.example.mediabelajarinteraktif.model.User
import com.example.mediabelajarinteraktif.siswa.ActivityUtama
import kotlinx.android.synthetic.main.activity_soal.*
import kotlinx.android.synthetic.main.screen_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivitySoal : AppCompatActivity() {

    private var listSoal : ArrayList<Soal> = ArrayList()
    private var listJawaban : HashMap<Int, String> = HashMap()
    private var current = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)

        ApiClient().getService()
            .getSoal()
            .enqueue(object : Callback<List<Soal>> {
                override fun onResponse(call: Call<List<Soal>>, response: Response<List<Soal>>) {
                    if(response.code() == 200) {
                        response.body().let {
                            if(it != null){
                                listSoal = it as ArrayList<Soal>
                                for (soal in listSoal){
                                    soal.pilihanShuffle = soal.pilihan?.toMutableList()
                                    soal.pilihanShuffle?.shuffle()
                                }
                                setSoal()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<Soal>>, t: Throwable) {
                    t.message?.let { Log.d("API: ", it) }
                }
            })

        btnPrev.visibility = View.GONE

        btnPrev.setOnClickListener {
            current -= 1
            setSoal()
            btnPrev.visibility = if(current == 0) View.GONE else View.VISIBLE
            btnNext.visibility = View.VISIBLE
        }

        btnNext.setOnClickListener {
            current += 1
            setSoal()
            btnPrev.visibility = View.VISIBLE
            btnNext.visibility = if(current == listSoal.size - 1) View.GONE else View.VISIBLE
        }

        btnSubmit.setOnClickListener {
            val intent = Intent(this, ActivitySkor::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    private fun setSoal(){
        soalKe.text = (current + 1).toString()
        soalTotal.text = listSoal.size.toString()
        textSoal.text = listSoal[current].soal
        pilihanA.text = "${listSoal[current].pilihanShuffle?.get(0)?.pilihan}"
        pilihanA.isChecked = listJawaban[current] == "A"
        pilihanB.text = "${listSoal[current].pilihanShuffle?.get(1)?.pilihan}"
        pilihanB.isChecked = listJawaban[current] == "B"
        pilihanC.text = "${listSoal[current].pilihanShuffle?.get(2)?.pilihan}"
        pilihanC.isChecked = listJawaban[current] == "C"
        pilihanD.text = "${listSoal[current].pilihanShuffle?.get(3)?.pilihan}"
        pilihanD.isChecked = listJawaban[current] == "D"
        pilihanE.text = "${listSoal[current].pilihanShuffle?.get(4)?.pilihan}"
        pilihanE.isChecked = listJawaban[current] == "E"
    }
}