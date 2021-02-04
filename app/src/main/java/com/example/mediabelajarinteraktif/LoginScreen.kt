package com.example.mediabelajarinteraktif

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.mediabelajarinteraktif.guru.ActivitySoal
import com.example.mediabelajarinteraktif.model.User
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
            ApiClient().getService()
            .login(textUsername.text.toString())
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.code() == 200) {
                        response.body().let {
                            if(it != null) {
                                val sharedPref = getSharedPreferences("auth", Context.MODE_PRIVATE)
                                with(sharedPref.edit()){
                                    putInt("id", it.id)
                                    putString("nama", it.nama)
                                    putString("username", it.username)
                                    putInt("user_level", it.user_level)
                                    apply()
                                }
                                val intent = Intent(this@LoginScreen, ActivitySoal::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
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
