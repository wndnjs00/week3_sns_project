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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.regex.Pattern

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
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val loginBackButton: ImageButton = findViewById(R.id.login_back_button)
        val loginButton: Button = findViewById(R.id.login_login_button)
        loginEmailEdittext = findViewById(R.id.login_email_edittext)
        loginPasswordEdittext = findViewById(R.id.login_password_edittext)
        loginNameEdittext = findViewById(R.id.login_name_edittext)

        val emailData = intent.getStringExtra("email")
        emailList.add(emailData ?: "-1")

        val passwordData = intent.getStringExtra("password")
        passwordList.add(passwordData ?: "-1")

        val nameData = intent.getStringExtra("name")
        nameList.add(nameData ?: "-1")

        loginBackButton.setOnClickListener {
            finish()
            //화면전환 애니메이션
            overridePendingTransition(R.anim.from_left_enter, R.anim.to_left_exit)

        }

        loginPasswordEdittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 텍스트가 변경될 때마다 호출된다.
                // 비밀번호를 입력할 때 실시간으로 비밀번호 형식을 검사한다.
                isRegularPwd(loginPasswordEdittext)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        // 이메일 유효성 검사
        // signupEmailEdittext에 TextWatcher 연결
        loginEmailEdittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // text가 바뀔 때마다 호출
                checkEmail()
            }
        })


        loginButton.setOnClickListener {
            if (loginEmailEdittext.length() == 0 || loginPasswordEdittext.length() == 0 || loginNameEdittext.length() == 0) {
                Toast.makeText(this, getString(R.string.empty_info), Toast.LENGTH_SHORT).show()
            } else if (emailList.contains(loginEmailEdittext.text.toString()) && passwordList.contains(
                    loginPasswordEdittext.text.toString()
                ) && nameList.contains(loginNameEdittext.text.toString())
            ) {

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", loginEmailEdittext.text.toString())
                intent.putExtra("name", loginNameEdittext.text.toString())
                startActivity(intent)

            } else {
                // 회원가입 정보에서 받은 데이터가 아닌 경우
                Toast.makeText(this, getString(R.string.notice_missinfo), Toast.LENGTH_SHORT).show()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun isRegularPwd(editText: EditText):Boolean {
        val pwd = editText.text.toString().trim()
        val pwdPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,16}$"
        val pattern = Pattern.matches(pwdPattern,pwd)
        if(pattern) {
            //유효성 검사 결과 정해진 비밀번호 형식일 경우
            editText.setTextColor(getColor(R.color.black))
            return true
        } else {
            // 유효성 검사 결과 비밀번호 형식이 아니면 EditText 테두리를 빨간색으로 처리한다.
            editText.setTextColor(getColor(R.color.red))
            return false
        }
    }

    fun checkEmail():Boolean {
        // 이메일 형식을 검사하는 정규식
        val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val email = loginEmailEdittext.text.toString().trim()  //공백제거
        val p = Pattern.matches(emailValidation, email)       // emailValidation과 email이 서로 패턴이 맞는지 확인
        if (p) {
            // 이메일 형식이 올바를경우 -> 텍스트색상 black
            loginEmailEdittext.setTextColor(getColor(R.color.black))
            return true
        } else {
            // 이메일 형식이 올바르지 않을경우 -> 텍스트색상 red
            loginEmailEdittext.setTextColor(getColor(R.color.red))
            return false
        }
    }
}