package com.example.search

import android.content.Intent
import android.widget.Toast
import androidx.core.view.isVisible

import androidx.recyclerview.widget.LinearLayoutManager


import com.example.mvpcore.view.BaseActivity
import com.example.search.common.Constant
import com.example.search.good.adapter.SearchHistoryAdapter
import com.example.search.good.view.MainActivity2


import com.example.stockpile.SPUtils
import kotlinx.android.synthetic.main.search.*


/**
@Name:yao
@CreateDate: 2021/9/28 13:56
@ProjectName: DS
@Package: com.example.search
@ClassName: SeachActivity
 */
class SeachActivity :BaseActivity() {
    private lateinit var mAdapter: SearchHistoryAdapter
    override fun initEvent() {

    }

    override fun initData() {
        initlayout()
        loadData()

        /**
         * 搜索
         */
        mSearchTv.setOnClickListener {
            Toast.makeText(this,"搜索",Toast.LENGTH_LONG).show()
            val intent= Intent(this, MainActivity2::class.java)
            startActivity(intent)
            doSearch()
            loadData()

        }
        /**
         * 清除历史记录
         */
        mClearBtn.setOnClickListener {
            SPUtils.remove(Constant.SP)
            loadData()
        }

        mLeftIv.setOnClickListener {
            finish()
        }
    }

    override fun initView() {
        //绘制布局前换位原来的布局样式
        setTheme(R.style.Theme_DS)
    }

    override fun getLayoutId(): Int {
       return R.layout.search
    }

    private fun initlayout() {
        mAdapter = SearchHistoryAdapter(this)
        mSearchHistoryRv.layoutManager= LinearLayoutManager(this)
        mSearchHistoryRv.adapter=mAdapter
    }

    /**
     * 从sp中加载数据
     */
    private fun loadData() {
        val set = SPUtils.getStringSet(Constant.SP)
        mNoDataTv.isVisible=set!!.isEmpty()
        mDataView.isVisible=set!!.isNotEmpty()
        if (set.isNotEmpty()){
            val list = mutableListOf<String>()
            list.addAll(set)
            mAdapter.setData(list)
        }
    }

    private fun doSearch(){
        //判断是否为空
        if (mKeywordEt.text.isNullOrEmpty()){
            Toast.makeText(this,"请输入需要搜索的关键字", Toast.LENGTH_LONG).show()
        }else{
            val inputValue = mKeywordEt.text.toString()
            SPUtils.putStringSet(Constant.SP, mutableSetOf(inputValue))
            enterList(inputValue)
        }
    }

    /**
     * 进入到商品页面
     */
    private fun enterList(value: String) {
        val name = mKeywordEt.text.toString()

    }
}