package com.example.mediabelajarinteraktif

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_loadingscreen.*

class LoadingScreen : AppCompatActivity() {
    private val SplashDelay: Long = 2000 //6 seconds
    private var mDelayHandler: Handler? = null
    private var progressStatus = 0
    var dummy:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_loading)

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, SplashDelay)
    }

    override fun onStart() {
        super.onStart()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    private fun launchMainActivity() {
        var intent = Intent(this, WelcomeScreen::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        this.finish()
        mDelayHandler!!.removeCallbacks(mRunnable)
    }

    override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

    private val mRunnable: Runnable = Runnable {
        Thread(Runnable {
            while (progressStatus < 100) {
                try {
                    dummy += 10
                    Thread.sleep(200)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                progressStatus = dummy
                progressSplash.progress = progressStatus
            }
            launchMainActivity()
        }).start()
    }
}