package com.example.search.good.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.search.R
import kotlinx.android.synthetic.main.item_goods.view.*

/**
@Name:yao
@CreateDate: 2021/10/7 9:35
@ProjectName: DS
@Package: com.example.search.good.adapter
@ClassName: GoodsDisAdapter
 */
class GoodsDisAdapter (context: Context):
    BaseRecyclerViewAdapter<String, GoodsDisAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.item_goods, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        //加载图片
        Glide.with(mContext).load(dataList[position]).into(holder.itemView.goodsim)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {

        }
    }
}
