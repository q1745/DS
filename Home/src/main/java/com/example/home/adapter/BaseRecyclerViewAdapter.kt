package com.example.home.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

/**
@Name:yao
@CreateDate: 2021/9/17 19:36
@ProjectName: DS
@Package: com.example.home.adapter
@ClassName: BaseRecyclerViewAdapter
 */
abstract  class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(var mContext: Context) : RecyclerView.Adapter<VH>() {

    //ItemClick事件
    var mItemClickListener: OnItemClickListener<T>? = null

    //数据集合
    var dataList: MutableList<T> = mutableListOf()

    /*
        设置数据
        Presenter处理过为null的情况，所以为不会为Null
     */
    fun setData(sources: MutableList<T>) {
        dataList = sources
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            if (mItemClickListener != null)
                mItemClickListener!!.onItemClick(dataList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    /*
        ItemClick事件声明
     */
    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.mItemClickListener = listener
    }
}
