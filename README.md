# androidsemina 1주차 실습과제 2020.10.11완료

“`  signupbtn.setOnClickListener{


            val intent= Intent(this,SignUpActivity::class.java)
            startActivityForResult(intent,0)
        } ` "
        
        ##빈칸 확인
        
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
### 필수과제
회원가입 버튼 눌렀을때 나타나는 회원가입 화면
![image](https://user-images.githubusercontent.com/48551119/95677545-2d555600-0c01-11eb-9047-a4ca1c9976e9.png)
### 심화과제

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
startActivityForResult()사용하여 로그인화면 내가 입력한 아이디와 비밀번호 뜨게하기
![image](https://user-images.githubusercontent.com/48551119/95677572-5544b980-0c01-11eb-86c5-1b9724b89085.png)

### 심화과제2
 SharedPreferences()를이용해서 아이디와 비밀번호가 저장되어있으면 자동로그인
![자동로그인](https://user-images.githubusercontent.com/48551119/95677417-6214dd80-0c00-11eb-8be5-269753360aa1.png)

 if(MySharedPreferences.getUserId(this).isNullOrBlank()
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
