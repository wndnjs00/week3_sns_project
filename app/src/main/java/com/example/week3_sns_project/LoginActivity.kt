package com.example.week3_sns_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var loginEmailEdittext: EditText
    private lateinit var loginPasswordEdittext: EditText
    private lateinit var loginNameEdittext: EditText

    companion object {
        // 정보가 누적될 수 있도록 companion object로 설정
        private var emailList = mutableListOf<String>()
        private var passwordList = mutableListOf<String>()
        private var nameList = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // 이게 무슨 말이지? (팀원설명요청)
        setContentView(R.layout.activity_login)

        val loginBackButton: ImageButton = findViewById(R.id.login_back_button)
        val loginButton : Button = findViewById(R.id.login_login_button)
        loginEmailEdittext = findViewById(R.id.login_email_edittext)
        loginPasswordEdittext = findViewById(R.id.login_password_edittext)
        loginNameEdittext = findViewById(R.id.login_name_edittext)

        val emailData = intent.getStringExtra("email")
        emailList.add(emailData ?: "-1")

        val passwordData = intent.getStringExtra("password")
        passwordList.add(passwordData ?: "-1")

        val nameData = intent.getStringExtra("name")
        nameList.add(nameData ?: "-1")

        loginBackButton.setOnClickListener{
            finish()
        }

        loginButton.setOnClickListener {
            if(loginEmailEdittext.length()==0||loginPasswordEdittext.length()==0||loginNameEdittext.length()==0) {
                Toast.makeText(this, "입력하지 않은 정보가 존재합니다!",Toast.LENGTH_SHORT).show()
            } else if(emailList.contains(loginEmailEdittext.toString())&& passwordList.contains(loginPasswordEdittext.toString())&&nameList.contains(loginNameEdittext.toString())) {
                /*
                - 회원가입 정보에 들어있는 데이터인 경우
                - 순서까지 매치하는 코드 짜기에는 아직 힘들 것 같아서 임시로 contain만 사용함
                */

                val intent = Intent(this,  MainActivity::class.java)
                intent.putExtra("email",loginEmailEdittext.text.toString())
                intent.putExtra("name",loginNameEdittext.text.toString())
                startActivity(intent)

            } else {
                // 회원가입 정보에서 받은 데이터가 아닌 경우
                Toast.makeText(this,"유효하지 않은 정보입니다!",Toast.LENGTH_SHORT).show()
            }

        }

        // 코드 설명 리뷰 요청
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}