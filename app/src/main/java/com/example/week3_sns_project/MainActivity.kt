package com.example.week3_sns_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.main_login_button)
        val signUpButton: Button = findViewById(R.id.main_signup_button)

        val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
        val signUpIntent = Intent(this@MainActivity, SignUpActivity::class.java)

        loginButton.setOnClickListener{
            startActivity(loginIntent)
        }

        signUpButton.setOnClickListener{
            startActivity(signUpIntent)
        }

    }
}