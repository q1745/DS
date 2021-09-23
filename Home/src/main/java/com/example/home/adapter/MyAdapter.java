package com.example.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.home.MainActivity;
import com.example.home.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name:yao
 * @CreateDate: 2021/9/19 10:08
 * @ProjectName: DS
 * @Package: com.example.home.adapter
 * @ClassName: MyAdapter
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] mDatas;

    public MyAdapter(String[] mDatas) {
        this.mDatas = mDatas;
    }
    List<Integer> list=new ArrayList<>();
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("tuanhui", "bind view");
        ImageView iv = (ImageView) holder.itemView.findViewById(R.id.iv_pic);
        TextView tv = (TextView) holder.itemView.findViewById(R.id.tv_title);
        iv.setImageResource(R.drawable.tou);

        tv.setText(mDatas[position]);
    }

    @Override
    public int getItemCount() {
        return mDatas.length;
    }
}
