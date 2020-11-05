package com.example.fragmentsemina

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.android1.*
import kotlinx.android.synthetic.main.fragment_blank.*


class BlankFragment : Fragment() {
    private lateinit var viewpagerAdapter: SampleViewpagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank,container,false)
        val fragment= BlankFragment()
        val fragment2= BlankFragment2()

        viewpagerAdapter= SampleViewpagerAdapter(getSupportFragmentManager())
       // sample_tab.addTab(sample_tab.newTab().setText("1 번"))
        viewpagerAdapter.fragments = listOf(
            BlankFragment2(),
            BlankFragment3(),
        )

        sample_tab_viewpager.adapter = viewpagerAdapter
// Tablayout과 연동
        sample_tab.setupWithViewPager(sample_tab_viewpager)
        sample_tab.apply {
            getTabAt(0)?.text = "첫 번째"
            getTabAt(1)?.text = "두 번째"
            getTabAt(2)?.text = "세 번째"
        }

// Tablayout과 연동

        return view
        //return inflater.inflate(R.layout.fragment_blank, container, false)
    }




}