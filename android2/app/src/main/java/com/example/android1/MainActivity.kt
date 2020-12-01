package com.example.android1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recyclerview.*

class MainActivity() : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //edittext에서 값 가져오기
        
//        name.text.toString()

        textview6.setOnClickListener {
            val intent= Intent(this,SignUpActivity::class.java)

            //  val intent= Intent(this,HomeActivity::class.java)
            // startActivityForResult(intent,0)
            startActivity(intent)
        }



        loginbtn.setOnClickListener {
            MySharedPreferences.clearUser(this)

            val intent= Intent(this,RecyclerviewActivity::class.java)

          //  val intent= Intent(this,HomeActivity::class.java)
                // startActivityForResult(intent,0)
            startActivity(intent)
        }

        signupbtn.setOnClickListener{


            val intent= Intent(this,SignUpActivity::class.java)
            startActivityForResult(intent,0)
        }


       /* if(MySharedPreferences.getUserId(this).isNullOrBlank()
            || MySharedPreferences.getUserPass(this).isNullOrBlank()) {
            Login()
        }
       else { // SharedPreferences 안에 값이 저장되어 있을 때 -> MainActivity로 이동
            Toast.makeText(this, "${MySharedPreferences.getUserId(this)}" +
                    "님 자동 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
*/


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                0 -> {

                    loginid.setText(data!!.getStringExtra("id").toString());
                    loginpass.setText(data!!.getStringExtra("pass").toString());
                }
            }
        }
    }

    object MySharedPreferences {
        private val MY_ACCOUNT : String = "account"

        fun setUserId(context: Context, input: String) {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = prefs.edit()
            editor.putString("MY_ID", input)
            editor.commit()
        }

        fun getUserId(context: Context): String {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            return prefs.getString("MY_ID", "").toString()
        }

        fun setUserPass(context: Context, input: String) {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = prefs.edit()
            editor.putString("MY_PASS", input)
            editor.commit()
        }

        fun getUserPass(context: Context): String {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            return prefs.getString("MY_PASS", "").toString()
        }

        fun clearUser(context: Context) {
            val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = prefs.edit()
            editor.clear()
            editor.commit()
        }

    }
    fun Login() {

        loginbtn.setOnClickListener {

            if(loginid.text.isNullOrBlank() || loginpass.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }
            else {
                MySharedPreferences.setUserId(this, loginid.text.toString())
               MySharedPreferences.setUserPass(this, loginpass.text.toString())
                Toast.makeText(this, "${MySharedPreferences.getUserId(this)}" +
                        "님 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}