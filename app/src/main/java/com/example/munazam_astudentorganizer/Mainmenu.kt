package com.example.munazam_astudentorganizer

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.munazam_astudentorganizer.Adapter.PredictorView
import com.example.munazam_astudentorganizer.Adapter.TunerView

class Mainmenu : AppCompatActivity() {
    private lateinit var opent: Button
    private lateinit var openp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmenu)

        val ac = supportActionBar
        ac!!.hide()

        opent = findViewById(R.id.button14)
        openp = findViewById(R.id.button15)

        opent.setOnClickListener(View.OnClickListener { opentuner() })
        openp.setOnClickListener(View.OnClickListener { openprdictor() })

        val x: Fragment = TunerView.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frameLayout, x)
        ft.commit()
    }

    fun opentuner() {
        println("tuner_template to be opened")
        val fm = supportFragmentManager
        val x: Fragment = TunerView.newInstance()
        val ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, x)
        ft.commit()
    }

    fun openprdictor() {
        println("predictor to be opened")
        val fm = supportFragmentManager
        val x: Fragment = PredictorView.newInstance()
        val ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, x)
        ft.commit()
    }
}
