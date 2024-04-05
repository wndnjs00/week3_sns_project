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
        enableEdgeToEdge() // 이게 무슨 말이지? (팀원설명요청)
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

        loginButton.setOnClickListener {
            if (loginEmailEdittext.length() == 0 || loginPasswordEdittext.length() == 0 || loginNameEdittext.length() == 0) {
                Toast.makeText(this, getString(R.string.empty_info), Toast.LENGTH_SHORT).show()
            } else if (emailList.contains(loginEmailEdittext.text.toString()) && passwordList.contains(
                    loginPasswordEdittext.text.toString()
                ) && nameList.contains(loginNameEdittext.text.toString())
            ) {
                /*
                - 회원가입 정보에 들어있는 데이터인 경우
                - 순서까지 매치하는 코드 짜기에는 아직 힘들 것 같아서 임시로 contain만 사용함
                */
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", loginEmailEdittext.text.toString())
                intent.putExtra("name", loginNameEdittext.text.toString())
                startActivity(intent)
                /*
                잘 모르겠는 부분: 데이터를 일단은 필요한 액티비티한테만 넘겨주고 싶은데,
                화면 전환시에는 또 다른 액티비티(데이터가 필요없는 액티비티) 가 필요한 경우
                이렇게 일일히 액티비티마다 데이터를 넘겨줘야 하나?
                */
            } else {
                // 회원가입 정보에서 받은 데이터가 아닌 경우
                Toast.makeText(this, getString(R.string.notice_missinfo), Toast.LENGTH_SHORT).show()
            }

        }

        // 코드 설명 리뷰 요청.
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
}