package com.example.week3_sns_project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    lateinit var emailData : String
    lateinit var nameData : String
    lateinit var intentToMyPage : Intent
    lateinit var intentToLogin : Intent
    lateinit var profileBtn : ImageButton
    lateinit var profileTextview : TextView

    companion object{
        lateinit var loginDataModel : LoginDataModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        emailData = intent.getStringExtra("email") ?: "-1"
        nameData = intent.getStringExtra("name") ?: "아무개"

        setContentView(R.layout.activity_main)
        profileBtn = findViewById(R.id.main_profile_imagebutton)
        profileTextview = findViewById(R.id.main_profile_textview)
        profileTextview.setText("안녕하세요 ${nameData}님!")

        profileBtn.setOnClickListener {
            intentToLogin = Intent(this,FirstActivity::class.java)
            startActivity(intentToLogin)
        }

        BottomNavigation()

        emailData = intent.getStringExtra("email") ?: "-1"
        nameData = intent.getStringExtra("name") ?: "-1"

        loginDataModel = LoginDataModel(emailData,nameData)
    }



    // bottomNavigation 구현함수
    private fun BottomNavigation(){


        val bottom_nav = findViewById<BottomNavigationView>(R.id.main_bottomnavgation)


        // main_framelayout레이아웃을 HomeFragment로 대체
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_framelayout, HomeFragment())
            .commitAllowingStateLoss()


        bottom_nav.setOnItemSelectedListener { item ->

            when (item.itemId){

                // home클릭시 HomeFragment()로 대체
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_framelayout, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                // mypage클릭시 MypageFragment()로 대체
                R.id.mypage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_framelayout, MypageFragment()) // fragment 를 쓸 때는 frameLayout을 꼭 써야하는가?
                        .commitAllowingStateLoss()

                    return@setOnItemSelectedListener true
                }

            }
            false
        }


    }

}