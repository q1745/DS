package com.example.home.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home.HomeFragment
import com.example.home.R
import kotlinx.android.synthetic.main.item.view.*

/**
@Name:yao
@CreateDate: 2021/9/17 19:42
@ProjectName: DS
@Package: com.example.home.adapter
@ClassName: HomeDiscountAdapter
 */
//
class HomeDiscountAdapter(context: Context):BaseRecyclerViewAdapter<String,HomeDiscountAdapter.ViewHolder>(context){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        //加载图片
        Glide.with(mContext).load(dataList[position]).into(holder.itemView.im)
        holder.itemView.tv.text="￥1263.00"
        holder.itemView.tv2.text="￥100.00"
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {
            view.tv.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG
            view.tv2.paint.isAntiAlias=true
        }
    }



}