package com.example.search.good.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.search.R
import kotlinx.android.synthetic.main.layout_search_history_item.view.*

/**
@Name:yao
@CreateDate: 2021/9/23 18:25
@ProjectName: DS
@Package: com.example.search.adapter
@ClassName: SearchHistoryAdapter
 */
class SearchHistoryAdapter(context: Context) : BaseRecyclerViewAdapter<String, SearchHistoryAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.layout_search_history_item,
                parent,
                false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val model = dataList[position]
        holder.itemView.mSearchHistoryTv.text = model

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
