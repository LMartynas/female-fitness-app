package com.example.fitnessapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_register_btn_register.setOnClickListener {
            val username = activity_register_et_username.text.toString()
            val password = activity_register_et_password.text.toString()
            val email = activity_register_em_email.text.toString()

            Log.d("MainActivity", "Username is $username")
            Log.d("MainActivity", "Password is $password")
            Log.d("MainActivity", "Email is $email")
        }

        activity_register_tv_login.setOnClickListener {
            Log.d("MainActivity", "Redirect to login activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        FirebaseAuth.getInstance()
    }
}
