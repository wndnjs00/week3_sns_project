package com.example.week3_sns_project

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
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

            // 화면전환 애니메이션
            if (Build.VERSION.SDK_INT >= 34) {
                overrideActivityTransition(Activity.OVERRIDE_TRANSITION_OPEN, R.anim.from_left_enter, R.anim.to_left_exit)
            } else {
                overridePendingTransition(R.anim.from_down_enter, R.anim.none)
            }


        }

        signUpButton.setOnClickListener{
            startActivity(signUpIntent)
        }

    }

}