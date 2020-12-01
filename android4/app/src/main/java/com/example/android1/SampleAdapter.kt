package com.example.android1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter (private val context: Context) : RecyclerView.Adapter<SampleViewholder>(){

    var data = mutableListOf<SampleData>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.sampleitemlist, parent, false)

        return SampleViewholder(view)
    }

    override fun onBindViewHolder(holder: SampleViewholder, position: Int) {
        //뷰홀더에있는 함수를 호출을해서 데이터를 넣어주는 작업
        holder.onBind(data[position])
        val item = data[position]

        holder.itemView.setOnClickListener {
            itemClickListner.onClick(it, position)
            Toast.makeText(it.context, "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()
            /*val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("aa",item.toString())
            holder.itemView.context.startActivity(intent)*/

        }


    }

    override fun getItemCount(): Int = data.size


    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

}