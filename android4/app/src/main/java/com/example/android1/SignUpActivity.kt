package com.example.android1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.sign

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        signbtn.setOnClickListener {
            if(nametext.length()>0&&idtext.length()>0&&passwordtext.length()>0){

                val email=idtext.text.toString()
                val password=passwordtext.text.toString()
                val name=nametext.text.toString()


                val call : Call<SampleResponseData2> =SampleServiceImpl.service.postSignup(
                    SampleRequestData2(email=email,password = password,username=name)
                )
                call.enqueue(object : Callback<SampleResponseData2> {
                    override fun onFailure(call: Call<SampleResponseData2>, t: Throwable) {

                    }

                    override fun onResponse(
                        call: Call<SampleResponseData2>,
                        response: Response<SampleResponseData2>
                    ) {

                        response.takeIf { it.isSuccessful }
                            ?.body()
                            ?.let { it->

                                //something

                            }?:showError(response.errorBody())

                    }
                })
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

    private fun showError(error : ResponseBody?){
        val e = error ?: return
        val ob = JSONObject(e.string())
        Toast.makeText(this, ob.getString("message"),Toast.LENGTH_SHORT).show()
    }
}