package com.example.week3_sns_project.Login

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.week3_sns_project.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val singupBackButton: ImageButton = findViewById(R.id.signup_back_button)

        singupBackButton.setOnClickListener{
            finish()
        }


    }
}