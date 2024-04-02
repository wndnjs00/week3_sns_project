package com.example.week3_sns_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.main_login_button)
        val signUpButton: Button = findViewById(R.id.main_signup_button)

        val loginIntent = Intent(this@FirstActivity, LoginActivity::class.java)
        val signUpIntent = Intent(this@FirstActivity, SignUpActivity::class.java)

        loginButton.setOnClickListener{
            startActivity(loginIntent)
        }

        signUpButton.setOnClickListener{
            startActivity(signUpIntent)
        }

    }
}