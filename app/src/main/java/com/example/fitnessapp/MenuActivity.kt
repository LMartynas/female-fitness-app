package com.example.fitnessapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        activity_menu_btn_vtadvice.setOnClickListener {
            Log.d("MenuActivity", "Redirect to View Training Advice activity")

            val intent = Intent(this, VIewTrainingAdviceActivity::class.java)
            startActivity(intent)
        }

        activity_menu_btn_trackmcycle.setOnClickListener {
            Log.d("MenuActivity", "Go to Track Menstrual Cycle activity")

            val intent = Intent(this, TrackMenstrualCycleActivity::class.java)
            startActivity(intent)
        }
    }


}