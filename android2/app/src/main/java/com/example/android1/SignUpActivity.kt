package com.example.android1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlin.math.sign

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        signbtn.setOnClickListener {
            if(nametext.length()>0&&idtext.length()>0&&passwordtext.length()>0){
                Toast.makeText(this,"회원가입 완료", Toast.LENGTH_SHORT).show()


                val intent = Intent()
                intent.putExtra("id", idtext.text.toString())
                intent.putExtra("pass", passwordtext.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()

            }
            else if(nametext.length()==0||idtext.length()==0||passwordtext.length()==0){
                Toast.makeText(this,"빈칸이 있습니다.", Toast.LENGTH_SHORT).show()

            }
        }

    }
}