package com.example.week3_sns_project

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.week3_sns_project.R
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    private lateinit var signupEmailEdittext: EditText
    private lateinit var signupPasswordEdittext: EditText
    private lateinit var signupCheckpasswordEdittext: EditText
    private lateinit var signupNameEdittext: EditText
    private lateinit var signupSignupButton: Button
    private lateinit var signupBackButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        signupBackButton = findViewById(R.id.signup_back_button)
        signupSignupButton = findViewById(R.id.signup_signup_button)

        signupEmailEdittext = findViewById(R.id.signup_email_edittext)
        signupPasswordEdittext = findViewById(R.id.signup_password_edittext)
        signupCheckpasswordEdittext = findViewById(R.id.signup_checkpassword_edittext)
        signupNameEdittext = findViewById(R.id.signup_name_edittext)


        // 이메일 유효성 검사
        var emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

        fun checkEmail():Boolean {
            var email = signupEmailEdittext.text.toString().trim()
            val p = Pattern.matches(emailValidation, email)
            if (p) {
                signupEmailEdittext.setTextColor(getColor(R.color.black))
                return true
            } else {
                signupEmailEdittext.setTextColor(getColor(R.color.red))
                return false
            }
        }

        signupEmailEdittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEmail()
            }
        })

        // 비밀번호 유효성 검사


        signupBackButton.setOnClickListener {
            finish()
        }

        signupSignupButton.setOnClickListener {
            if (signupEmailEdittext.length() == 0 || signupPasswordEdittext.length() == 0 || signupCheckpasswordEdittext.length() == 0 || signupNameEdittext.length() == 0) {
                // 정보를 다 입력하지 않은 경우
                Toast.makeText(this, getString(R.string.request_info), Toast.LENGTH_SHORT).show()
            } else if (signupPasswordEdittext.text.toString() != signupCheckpasswordEdittext.text.toString()) {
                // '비밀번호'와 '비밀번호 확인' 데이터가 다른 경우
                Toast.makeText(this, getString(R.string.password_check), Toast.LENGTH_SHORT).show()
            } else {
                // registerForActivityResult 을 사용할 수 있을까? 하다가 일단 intent 로 받아옴
                intent = Intent(this, FirstActivity::class.java) // 넘기는 쪽이 FirstActivity 일 수는 없나?(팀원 리뷰 요청)
                intent.putExtra("email",signupEmailEdittext.text.toString()) // 근데 text.toString() 말고 toString() 만 쓰는거랑 무슨 차이지?(팀원 리뷰 요청)
                intent.putExtra("password",signupPasswordEdittext.text.toString())
                intent.putExtra("name",signupNameEdittext.text.toString())
                startActivity(intent)
            }
        }
    }
}