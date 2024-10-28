package com.example.munazam_astudentorganizer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val handler = Handler()
        handler.postDelayed({
            val i = Intent(this@MainActivity, Mainmenu::class.java)
            startActivity(i)
            finish()
        }, 4500)
    }
}
