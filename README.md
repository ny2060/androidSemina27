# androidsemina 1주차 실습과제 2020.10.11완료
```
signupbtn.setOnClickListener{


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
```
### 필수과제

회원가입 버튼 눌렀을때 나타나는 회원가입 화면

![image](https://user-images.githubusercontent.com/48551119/95677545-2d555600-0c01-11eb-9047-a4ca1c9976e9.png)

### 심화과제
```
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
```
 
startActivityForResult()사용하여 로그인화면 내가 입력한 아이디와 비밀번호 뜨게하기

![image](https://user-images.githubusercontent.com/48551119/95677572-5544b980-0c01-11eb-86c5-1b9724b89085.png)

### 심화과제2
 SharedPreferences()를이용해서 아이디와 비밀번호가 저장되어있으면 자동로그인
![자동로그인](https://user-images.githubusercontent.com/48551119/95677417-6214dd80-0c00-11eb-8be5-269753360aa1.png)
```
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
```      
        
# androidsemina 2주차 실습과제 2020.10.17완료

**RecyclerView 화면**
![image](https://user-images.githubusercontent.com/48551119/101049355-c7fd6000-35c6-11eb-87cc-9640ba0e2ee9.png)

**RecyclerActiviy 코드**
``` kotlin
class RecyclerviewActivity : AppCompatActivity() {

    private lateinit var sampleAdapter : SampleAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)





        sampleAdapter = SampleAdapter(this)






        rcv.adapter=sampleAdapter
        rcv.layoutManager = LinearLayoutManager(this)
       
        sampleAdapter.data = mutableListOf(
            SampleData(" 이름","안나영","20/10/18","이름은 안나영 별명은 기억이안나영, 생각이안나영, 이손안나입니다."),
            SampleData(" 나이","22살","20/10/18","생년월일은 1999년 8월 17일입니다."),
            SampleData(" 파트","안드로이드","20/10/18","현재 안드로이드 파트원이며" +
                    "파이썬 ,JAVA,C언어를 사용하고있습니다."),
            SampleData(" 취미","노는것","20/10/18","노는것을 좋아하며 보드게임, 레저스포츠 등등을 좋아합니다."),
        )
        sampleAdapter.notifyDataSetChanged()

        sampleAdapter.setItemClickListener( object : SampleAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = sampleAdapter.data [position]
                Log.d("SSS", "${position}번 리스트 선택")
                val intent = Intent(view.context, DetailActivity::class.java)
                intent.putExtra("title",item.title)
                intent.putExtra("subtitle",item.subTitle)
                intent.putExtra("date",item.date)
                intent.putExtra("detail",item.detail)
                startActivity(intent)
            }
        })
    }



}
```
**SampleViewholder 코드**
``` kotlin
class SampleViewholder (itemview: View):RecyclerView.ViewHolder(itemview){


    private val title: TextView=itemview.findViewById(R.id.title)
    private val subtitle: TextView=itemview.findViewById(R.id.subtitle)




    fun onBind(data : SampleData){
        Log.d("Test","onBind 호출")
        title.text=data.title
        subtitle.text=data.subTitle
    }
}
```
**SampleData 코드**
``` kotlin
data class SampleData(
    val title : String,
    val subTitle:String,
    val date:String,
    val detail:String
)
```
**상세화면 페이지**
![image](https://user-images.githubusercontent.com/48551119/101049137-971d2b00-35c6-11eb-84bd-ffedc6099a6d.png)

**2차 세미나 성장과제 1번**

```
 rcv.layoutManager = GridLayoutManager(this,2)
```

**GridLayout 화면**
![gridlayout](https://user-images.githubusercontent.com/48551119/101048979-6d640400-35c6-11eb-8e26-0cdd873c5c67.png)
       
       
# 안드로이드 세미나 필수과제 3 2020.11.05완료
하단탭+뷰페이저
![첫번째 페이지](https://user-images.githubusercontent.com/48551119/98194793-89db3500-1f63-11eb-859f-ee6ae4fef42c.png)
```
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank,container,false)
   
// Tablayout과 연동

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewpagerAdapter= Tablayoutadapter(requireActivity().supportFragmentManager)
        // sample_tab.addTab(sample_tab.newTab().setText("1 번"))
        viewpagerAdapter.fragmentss = listOf(
            BlankFragment2(),
            BlankFragment3(),
        )

        sample_tab_viewpager.adapter = viewpagerAdapter
// Tablayout과 연동
        sample_tab.setupWithViewPager(sample_tab_viewpager)
        sample_tab.apply {
            getTabAt(0)?.text = "INFO"
            getTabAt(1)?.text = "OTHER"

        }

    }
```
fragment에 tablayout을 연결.
Tablayoutadpater를 만들어 주었음.
```
class Tablayoutadapter (fm : FragmentManager)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    var fragmentss= listOf<Fragment>()
    override fun getItem(position: Int): Fragment =when(position){
        0->BlankFragment2()
        1->BlankFragment3()

        else -> throw IllegalStateException("unexpected position $position")
    }

    override fun getCount(): Int =2
    
}
```
![두번째 페이지](https://user-images.githubusercontent.com/48551119/98194936-e63e5480-1f63-11eb-80af-351c6c5cc70c.png)
```
private lateinit var sampleAdapter : SampleAdapter
    lateinit var recyclerView1 : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_blank2, container, false)
        sampleAdapter = SampleAdapter(requireContext())

        recyclerView1 = rootView.findViewById(R.id.rcv2!!)as RecyclerView



        recyclerView1.adapter = sampleAdapter
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
     
        sampleAdapter.data = mutableListOf(
            SampleData(" 이름","안나영","20/10/18","이름은 안나영 별명은 기억이안나영, 생각이안나영, 이손안나입니다."),
            SampleData(" 나이","22살","20/10/18","생년월일은 1999년 8월 17일입니다."),
            SampleData(" 파트","안드로이드","20/10/18","현재 안드로이드 파트원이며" +
                    "파이썬 ,JAVA,C언어를 사용하고있습니다."),
            SampleData(" 취미","노는것","20/10/18","노는것을 좋아하며 보드게임, 레저스포츠 등등을 좋아합니다."),
        )


        sampleAdapter.notifyDataSetChanged()

        sampleAdapter.setItemClickListener( object : SampleAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = sampleAdapter.data [position]
                Log.d("SSS", "${position}번 리스트 선택")
                val intent = Intent(view.context, DetailActivity::class.java)
                intent.putExtra("title",item.title)
                intent.putExtra("subtitle",item.subTitle)
                intent.putExtra("date",item.date)
                intent.putExtra("detail",item.detail)
                startActivity(intent)
            }
        })

        return rootView
    }
```
recyclerview를 연결해 주었음.
![세번째 페이지](https://user-images.githubusercontent.com/48551119/98194994-0ec64e80-1f64-11eb-98ae-b5108cec3652.png)
```
 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }
```
빈페이지

+++추가로 BottomNaviActivity 와 ViewpagerAcitivity
#BottomNaviActivity 
```
class BottomNaviActivity : AppCompatActivity(){

    private lateinit var  viewpagerAdapter: SampleViewpagerAdapter
}
```
#ViewpagerAcitivity
```
class ViewpagerActivity : AppCompatActivity() {
    var code =1

    private  lateinit var viewpagerAdapter: SampleViewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        val fragment= BlankFragment()
        val fragment2= BlankFragment2()
        val activity1=TabviewpagerActivity()
        viewpagerAdapter= SampleViewpagerAdapter(supportFragmentManager)
        viewpagerAdapter.fragments= listOf(
            BlankFragment(),
            BlankFragment2(),
            BlankFragment3()
        )

        sample_bottom_viewpager.adapter=viewpagerAdapter




// ViewPager slide 시 BottomNavi 변경
        sample_bottom_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}
            // ViewPager의 페이지 중 하나가 선택된 경우
            override fun onPageSelected(position: Int) {
                sample_bottom_navi.menu.getItem(position).isChecked = true


            }
        })
//바텀 네비게이션 세팅
        sample_bottom_navi.setOnNavigationItemSelectedListener {
            var index by Delegates.notNull<Int>()
            when (it.itemId) {
                R.id.menu_account -> index = 0
                R.id.menu_camera -> index = 1
                R.id.menu_chat -> index = 2
            }
            sample_bottom_viewpager.currentItem = index
            true
        }


    }
}
```

### 안드로이드 세미나 과제 6주차 2020/12/02
postmas test 화면 / 성공 화면

![성공](https://user-images.githubusercontent.com/48551119/100762241-1845b800-3437-11eb-937a-48f9ea7c064b.png)

postmas test 화면 / 이미 회원가입을 한 후라서 중복된 값 체크

![image](https://user-images.githubusercontent.com/48551119/100760508-2b578880-3435-11eb-83e1-0544ad83851d.png)

##비밀번호 틀린경우(화면)

![비밀번호 틀린경우](https://user-images.githubusercontent.com/48551119/100760658-5510af80-3435-11eb-8924-80a76556a6ba.png)

##로그인 성공 화면

![로그인 성공](https://user-images.githubusercontent.com/48551119/100760917-a325b300-3435-11eb-9e52-892625968514.png)

##회원가입 완료 화면

![회원가입 완료](https://user-images.githubusercontent.com/48551119/100761050-c8b2bc80-3435-11eb-8d4d-7bcbb42d63ad.png)

**인터페이스 SampleService**
```
interface SampleService{

    @Headers("Content-Type:application/json")
    @POST("/users/signin")
    fun postLogin(
        @Body body : SampleRequestData
    ) : Call<SampleResponseData>

    @Headers("Content-Type:application/json")
    @POST("/users/signup")
    fun postSignup(
        @Body body : SampleRequestData2


    ):Call<SampleResponseData2>
}
```

**Requestdatalogin**
```
data class SampleRequestData(
    val email : String,
    val password : String
)
```
**Responsedatalogin**
```
data class SampleResponseData(
    val data: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val email: String,
        val password: String,
        val userName: String
    )
}
```
**RequestDataSignup**
```

data class SampleRequestData2(
    val email : String,
    val password : String,
    val username : String
)
```
**ResponseDataSignup**
```

data class SampleResponseData2(
    val data: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val email: String,
        val password: String,
        val userName: String
    )
}
```

