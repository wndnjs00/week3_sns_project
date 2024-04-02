package com.example.week3_sns_project

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MyPageActivity : AppCompatActivity() {

    private lateinit var mypage_btn_back:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mypage)
        mypage_btn_back = findViewById(R.id.mypage_btn_back)
        mypage_btn_back.setOnClickListener {
            finish()
        }
    }
}