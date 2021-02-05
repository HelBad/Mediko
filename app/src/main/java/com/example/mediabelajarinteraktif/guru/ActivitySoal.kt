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
import com.example.mediabelajarinteraktif.OnItemActionCallback
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.model.Soal
import com.example.mediabelajarinteraktif.model.Status
import kotlinx.android.synthetic.main.activity_soal.*
import kotlinx.android.synthetic.main.activity_soal_guru.*
import kotlinx.android.synthetic.main.activity_soal_guru.textSoal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivitySoal : AppCompatActivity() {
    lateinit var nilaiSoalGuru: ImageView
    lateinit var closeSoalGuru: ImageView
    private var current = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal_guru)

        nilaiSoalGuru = findViewById(R.id.nilaiSoalGuru)
        closeSoalGuru = findViewById(R.id.closeSoalGuru)

        nilaiSoalGuru.setOnClickListener {
            val intent = Intent(this, ActivityNilai::class.java)
            startActivity(intent)
        }

        closeSoalGuru.setOnClickListener {
            val intent = Intent(this, ExitScreen::class.java)
            startActivity(intent)
        }

        tambahSoal.setOnClickListener {
            if(current == 0){
                ApiClient().getService()
                    .addSoal(
                        textSoal.text.toString(),
                        uraianA.text.toString(),
                        uraianB.text.toString(),
                        uraianC.text.toString(),
                        uraianD.text.toString(),
                        uraianE.text.toString(),
                        radioKunci.indexOfChild(findViewById(radioKunci.checkedRadioButtonId))
                    )
                    .enqueue(object : Callback<Status> {
                        override fun onResponse(call: Call<Status>, response: Response<Status>) {
                            if (response.code() == 200) {
                                response.body().let {
                                    if(it?.status == "success"){
                                        tambahSoal.text = "Add"
                                        current = 0
                                        textSoal.text = null
                                        uraianA.text = null
                                        uraianB.text = null
                                        uraianC.text = null
                                        uraianD.text = null
                                        uraianE.text = null

                                        kunciA.isChecked = false
                                        kunciB.isChecked = false
                                        kunciC.isChecked = false
                                        kunciD.isChecked = false
                                        kunciE.isChecked = false

                                        loadSoal()
                                    }
                                }
                            }
                        }

                        override fun onFailure(call: Call<Status>, t: Throwable) {
                            t.message?.let { Log.d("API: ", it) }
                        }
                    })
            }
            else{
                ApiClient().getService()
                    .editSoal(
                        current,
                        textSoal.text.toString(),
                        uraianA.text.toString(),
                        uraianB.text.toString(),
                        uraianC.text.toString(),
                        uraianD.text.toString(),
                        uraianE.text.toString(),
                        radioKunci.indexOfChild(findViewById(radioKunci.checkedRadioButtonId))
                    )
                    .enqueue(object : Callback<Status> {
                        override fun onResponse(call: Call<Status>, response: Response<Status>) {
                            if (response.code() == 200) {
                                response.body().let {
                                    if(it?.status == "success"){
                                        tambahSoal.text = "Add"
                                        current = 0
                                        textSoal.text = null
                                        uraianA.text = null
                                        uraianB.text = null
                                        uraianC.text = null
                                        uraianD.text = null
                                        uraianE.text = null

                                        kunciA.isChecked = false
                                        kunciB.isChecked = false
                                        kunciC.isChecked = false
                                        kunciD.isChecked = false
                                        kunciE.isChecked = false

                                        loadSoal()
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
        loadSoal()
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    fun loadSoal(){
        ApiClient().getService()
            .getSoal()
            .enqueue(object : Callback<List<Soal>> {
                override fun onResponse(call: Call<List<Soal>>, response: Response<List<Soal>>) {
                    if (response.code() == 200) {
                        response.body().let {
                            if (it != null) {
                                rvSoal.setHasFixedSize(true)
                                rvSoal.layoutManager = LinearLayoutManager(this@ActivitySoal)
                                val adapter = AdapterSoal(it as ArrayList<Soal>)
                                adapter.notifyDataSetChanged()
                                adapter.setOnItemEditCallback(object : OnItemActionCallback {
                                    override fun onItemAction(data: Any) {
                                        tambahSoal.text = "Save"
                                        current = (data as Soal).id
                                        textSoal.setText(data.soal)
                                        uraianA.setText(data.pilihan?.get(0)?.pilihan)
                                        uraianB.setText(data.pilihan?.get(1)?.pilihan)
                                        uraianC.setText(data.pilihan?.get(2)?.pilihan)
                                        uraianD.setText(data.pilihan?.get(3)?.pilihan)
                                        uraianE.setText(data.pilihan?.get(4)?.pilihan)

                                        data.pilihan?.forEach { pil ->
                                            if(pil.isBenar == 1){
                                                when(data.pilihan.indexOf(pil)){
                                                    0 -> kunciA.isChecked = true
                                                    1 -> kunciB.isChecked = true
                                                    2 -> kunciC.isChecked = true
                                                    3 -> kunciD.isChecked = true
                                                    4 -> kunciE.isChecked = true
                                                }
                                            }
                                        }
                                    }
                                })
                                adapter.setOnItemDeleteCallback(object : OnItemActionCallback {
                                    override fun onItemAction(data: Any) {
                                        TODO("Not yet implemented")
                                    }
                                })
                                rvSoal.adapter = adapter
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<Soal>>, t: Throwable) {
                    t.message?.let { Log.d("API: ", it) }
                }
            })
    }
}