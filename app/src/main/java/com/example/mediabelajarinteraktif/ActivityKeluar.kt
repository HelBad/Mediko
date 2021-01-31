package com.example.mediabelajarinteraktif

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ActivityKeluar : AppCompatActivity() {
//    lateinit var alertDialog: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keluar)

//        alertDialog = AlertDialog.Builder(this)
    }

    override fun onStart() {
        super.onStart()
//        onBackPressed()
        this.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

//    override fun onBackPressed() {
//        alertDialog.setTitle("Close Application")
//        alertDialog.setMessage("“Are you sure want to quit this application ?")
//            .setCancelable(false)
//            .setPositiveButton("YES", object: DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface, id:Int) {
//                    finishAffinity()
//                }
//            })
//            .setNegativeButton("NO", object: DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface, id:Int) {
//                    dialog.cancel()
//                }
//            }).create().show()
//    }
}