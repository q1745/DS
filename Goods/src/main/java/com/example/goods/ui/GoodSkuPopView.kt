package com.example.goods.ui

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.RelativeLayout
import com.example.goods.R
import kotlinx.android.synthetic.main.goods_sku_pop_layout.view.*

class GoodSkuPopView(context: Activity) : PopupWindow(context) , View.OnClickListener {

    private val mRootView:View
    private val mContext : Context
//    private val skuList:List<SkuView>

    init{
        mContext = context

        //获取根视图
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mRootView = inflater.inflate(R.layout.goods_sku_pop_layout, null)

        initView()

        //设置布局
        this.contentView = mRootView
        //设置属性
        this.width = ViewGroup.LayoutParams.MATCH_PARENT
        this.height = ViewGroup.LayoutParams.MATCH_PARENT
        //获取焦点
        this.isFocusable = true
        //弹框设置动画
        this.animationStyle = R.style.BottomAnim
        background.alpha = 150


        mRootView.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val height = mRootView.findViewById<RelativeLayout>(R.id.mPopView).height
                val y = event!!.y
                if (event.action == MotionEvent.ACTION_UP){
                    if (y < height) dismiss()
                }
                return true
            }
        })

    }

    /**
     * 初始化控件，增加监听
     */
    private fun initView() {
        mRootView.mCloseIv.setOnClickListener(this)
    }

    /**
     * 监听事件
     */
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.mCloseIv -> dismiss()
        }
    }

}