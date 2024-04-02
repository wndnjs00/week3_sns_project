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

class SignUpActivity : AppCompatActivity() {

    private lateinit var signupEmailEdittext: EditText
    private lateinit var signupPasswordEdittext: EditText
    private lateinit var signupCheckpasswordEdittext: EditText
    private lateinit var signupNameEdittext: EditText
    private lateinit var signupSignupButton: Button
    private lateinit var singupBackButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        singupBackButton = findViewById(R.id.signup_back_button)
        signupSignupButton = findViewById(R.id.signup_signup_button)

        signupEmailEdittext = findViewById(R.id.signup_email_edittext)
        signupPasswordEdittext = findViewById(R.id.signup_password_edittext)
        signupCheckpasswordEdittext = findViewById(R.id.signup_checkpassword_edittext)
        signupNameEdittext = findViewById(R.id.signup_name_edittext)

        singupBackButton.setOnClickListener {
            if (signupEmailEdittext.length() == 0 || signupPasswordEdittext.length() == 0 || signupCheckpasswordEdittext.length() == 0 || signupNameEdittext.length() == 0) {
                // 정보를 다 입력하지 않은 경우
                Toast.makeText(this, "정보를 아직 다 입력하지 않았습니다", Toast.LENGTH_SHORT).show()
            } else if (signupPasswordEdittext != signupCheckpasswordEdittext) {
                // '비밀번호'와 '비밀번호 확인' 데이터가 다른 경우
                Toast.makeText(this, "비밀번호가 서로 다릅니다!", Toast.LENGTH_SHORT).show()
            } else {
                // registerForActivityResult 을 사용할 수 있을까? 하다가 일단 intent 로 받아옴
                intent = Intent(this, LoginActivity::class.java) // 넘기는 쪽이 FirstActivity 일 수는 없나?(팀원 리뷰 요청)
                intent.putExtra("email",signupEmailEdittext.text.toString()) // 근데 text.toString() 말고 toString() 만 쓰는거랑 무슨 차이지?(팀원 리뷰 요청)
                intent.putExtra("password",signupPasswordEdittext.text.toString())
                intent.putExtra("name",signupNameEdittext.text.toString())
                finish()
                //startActivity(intent) 꼭 써야지 데이터가 전달되는건가??
            }
        }
    }
}