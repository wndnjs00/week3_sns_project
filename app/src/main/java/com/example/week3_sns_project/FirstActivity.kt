package com.example.week3_sns_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)

        val loginButton: Button = findViewById(R.id.main_login_button)
        val signUpButton: Button = findViewById(R.id.main_signup_button)

        val loginIntent = Intent(this@FirstActivity, LoginActivity::class.java)
        val signUpIntent = Intent(this@FirstActivity, SignUpActivity::class.java)

        val emailData = intent.getStringExtra("email")
        val passwordData = intent.getStringExtra("password")
        val nameData = intent.getStringExtra("name")

        loginButton.setOnClickListener{
            loginIntent.putExtra("email",emailData)
            loginIntent.putExtra("password",passwordData)
            loginIntent.putExtra("name",nameData)
            startActivity(loginIntent)
        }

        signUpButton.setOnClickListener{
            startActivity(signUpIntent)
        }

    }
}