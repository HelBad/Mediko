package com.example.mediabelajarinteraktif.siswa.latihan

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mediabelajarinteraktif.ApiClient
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.model.Pilihan
import com.example.mediabelajarinteraktif.model.Soal
import kotlinx.android.synthetic.main.activity_soal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivitySoal : AppCompatActivity() {

    private var listSoal : ArrayList<Soal> = ArrayList()
    private var mapJawabanSubmit : HashMap<Int, Pilihan> = HashMap()
    private var mapJawabanView : HashMap<Int, String> = HashMap()
    private var current = 0

    private var nama : String? = null
    private var noAbsen : String? = null
    private var kelas : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)

        nama = intent.getStringExtra("nama")
        noAbsen = intent.getStringExtra("no_absen")
        kelas = intent.getStringExtra("kelas")

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
                                layoutSoal.visibility = View.VISIBLE
                                loading.visibility = View.GONE
                                setSoal()

                                timerSoal.base = SystemClock.elapsedRealtime()
                                timerSoal.start()
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
            var nilai = 0
            var benar = 0
            var salah = 0
            mapJawabanSubmit.map {
                if(it.value.isBenar == 1) {
                    nilai += 5
                    benar++
                }
                else{
                    salah++
                }
            }

            if(mapJawabanSubmit.size < listSoal.size) salah += listSoal.size - mapJawabanSubmit.size

            intent.putExtra("nama", nama)
            intent.putExtra("no_absen", noAbsen)
            intent.putExtra("kelas", kelas)
            intent.putExtra("benar", benar)
            intent.putExtra("salah", salah)
            intent.putExtra("nilai", nilai)
            intent.putExtra("time", (SystemClock.elapsedRealtime()-timerSoal.base))
            startActivity(intent)
        }

        pilihanGroup.setOnCheckedChangeListener { _, _ ->
            val radioIndex = pilihanGroup.indexOfChild(findViewById(pilihanGroup.checkedRadioButtonId))
            when(radioIndex){
                0 -> {
                    mapJawabanView[current] = "A"
                }
                1 -> {
                    mapJawabanView[current] = "B"
                }
                2 -> {
                    mapJawabanView[current] = "C"
                }
                3 -> {
                    mapJawabanView[current] = "D"
                }
                4 -> {
                    mapJawabanView[current] = "E"
                }
            }
            listSoal[current].pilihanShuffle?.get(radioIndex)?.let {
                mapJawabanSubmit[current] = it
            }
            Log.d("jawaban", mapJawabanSubmit.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    private fun setSoal() {
        soalKe.text = (current + 1).toString()
        soalTotal.text = listSoal.size.toString()
        textSoal.text = listSoal[current].soal
        when(mapJawabanView[current]){
            "A" -> pilihanA.isChecked = true
            "B" -> pilihanB.isChecked = true
            "C" -> pilihanC.isChecked = true
            "D" -> pilihanD.isChecked = true
            "E" -> pilihanE.isChecked = true
            else -> {
                pilihanA.isChecked = false
                pilihanB.isChecked = false
                pilihanC.isChecked = false
                pilihanD.isChecked = false
                pilihanE.isChecked = false
            }
        }
        pilihanA.text = "${listSoal[current].pilihanShuffle?.get(0)?.pilihan}"
        pilihanB.text = "${listSoal[current].pilihanShuffle?.get(1)?.pilihan}"
        pilihanC.text = "${listSoal[current].pilihanShuffle?.get(2)?.pilihan}"
        pilihanD.text = "${listSoal[current].pilihanShuffle?.get(3)?.pilihan}"
        pilihanE.text = "${listSoal[current].pilihanShuffle?.get(4)?.pilihan}"
    }
}
