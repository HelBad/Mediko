package com.example.mediabelajarinteraktif

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.mediabelajarinteraktif.api.ApiClient
import com.example.mediabelajarinteraktif.guru.ActivitySoal
import com.example.mediabelajarinteraktif.model.User
import com.example.mediabelajarinteraktif.siswa.ActivityUtama
import kotlinx.android.synthetic.main.screen_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginScreen : AppCompatActivity() {
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_login)

        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            ApiClient().getService().login(textUsername.text.toString()).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    Toast.makeText(this@LoginScreen, "Mohon tunggu sebentar", Toast.LENGTH_SHORT).show()
                    if(response.code() == 200) {
                        response.body().let {
                            if(it != null) {
                                val sharedPref = getSharedPreferences("auth", Context.MODE_PRIVATE)
                                with(sharedPref.edit()) {
                                    putInt("id", it.id)
                                    putString("nama", it.nama)
                                    putString("username", it.username)
                                    putInt("user_level", it.user_level)
                                    apply()
                                }
                                if(it.user_level == 1) {
                                    val intent = Intent(this@LoginScreen, ActivitySoal::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                                else {
                                    val intent = Intent(this@LoginScreen, ActivityUtama::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }
                }
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@LoginScreen, "Username Salah", Toast.LENGTH_SHORT).show()
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