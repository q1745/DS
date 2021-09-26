package com.example.sort.mvp.view

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.example.mvpcore.view.MVPFragment
import com.example.protocol.BaseReposEntity
import com.example.sort.R
import com.example.sort.adapter.FirstRecAdapter
import com.example.sort.adapter.SecondRecAdapter
import com.example.sort.mvp.injection.component.DaggerSortComponent
import com.example.sort.mvp.injection.component.SortComponent

import com.example.sort.mvp.injection.module.SecondViewModule
import com.example.sort.mvp.injection.module.ViewModule

import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.model.entity.SecondEntity
import com.example.sort.mvp.presenter.FirstPresenter
import com.example.sort.mvp.presenter.SecondPresenter
import com.example.util.utils.LogUtil
import kotlinx.android.synthetic.main.fragment_sort_layout.*
import javax.inject.Inject

class SortFragment : MVPFragment(),FirstView,SecondView{


    @Inject
    lateinit var mpresenter:FirstPresenter

    @Inject
    lateinit var secondpresenter: SecondPresenter

    var sortComponent: SortComponent? = null

    var firstRecAdapter: FirstRecAdapter? = null
    var secondRecAdapter: SecondRecAdapter? = null


    override fun initEvent() {

    }
    /**
     * 初始化布局管理器
     */
    override fun initView() {
        sort_first_list_recyclerview.layoutManager = LinearLayoutManager(context)
        sort_second_list_recyclerview.layoutManager = GridLayoutManager(context,3)
    }

    override fun initData() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sort_layout
    }

    override fun initInjection() {
        sortComponent = DaggerSortComponent.builder().activityComponent(activityComponent)
            .viewModule(ViewModule(this))
            .secondViewModule(SecondViewModule(this))
            .build()
        sortComponent?.injectSortFragment(this)
        //进行网络请求
        mpresenter?.getList()
    }



    override fun success(bean:BaseReposEntity<FirstEntity>) {
        //设置第一个元素选中属性为true
        bean.data.get(0).isSelected = true
        firstRecAdapter = FirstRecAdapter(bean.data)
        sort_first_list_recyclerview.adapter = firstRecAdapter

        //默认获取第一个数据
        secondpresenter.getSecondList(1)
        //左侧recycleview点击事件
        firstRecAdapter?.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                //获取所有元素
                val data = adapter.data as MutableList<FirstEntity>
                //获取选中元素
                val data1 = adapter.data.get(position) as FirstEntity
                //获取选中元素名称
                val categoryName = data1.categoryName
                //循环所有元素
                for (item in data) {
                    //如果选中元素名称与所有元素中相等，设置选中属性为true
                    if (item.categoryName.equals(categoryName)) {
                        item.isSelected = true
                    } else {
                        item.isSelected = false
                    }
                }
                //刷新第一个适配器
                firstRecAdapter!!.notifyDataSetChanged()
                //通过选中属性id获取右侧recycleview数据
                secondpresenter.getSecondList(data1.id)
            }
        })
    }

    override fun failed(throwable: Throwable) {
        LogUtil.e("123","failed" + throwable.message.toString())
    }
    //右侧recycleview获取数据成功
    override fun secondSuccess(entity: BaseReposEntity<SecondEntity>) {
        LogUtil.e("123","secondSuccess" + entity.data.toString())
        //如果值为空，设置recycleview不可见，textview可见。相反则对应
        if(entity.data == null) {
            sort_second_list_recyclerview.visibility = View.GONE
            sort_second_list_text.visibility = View.VISIBLE
            return
        }
        sort_second_list_recyclerview.visibility = View.VISIBLE
        sort_second_list_text.visibility = View.GONE

        secondRecAdapter = SecondRecAdapter(entity.data)
        sort_second_list_recyclerview.adapter = secondRecAdapter
        //右侧点击事件
        secondRecAdapter!!.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {

            }
        })

    }

    override fun secondFailed(throwable: Throwable) {
        LogUtil.e("123","secondFailed" + throwable.message.toString())
    }

}