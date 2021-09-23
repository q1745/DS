package com.example.home

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home.adapter.HomeDiscountAdapter
import com.example.home.adapter.MyAdapter
import com.example.home.common.*
import com.example.mvpcore.view.BaseActivity
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout.*

/**
@Name:yao
@CreateDate: 2021/9/17 18:37
@ProjectName: DS
@Package: com.example.home
@ClassName: HomeFragment
 */
class HomeFragment :BaseActivity(){
    private var mScreenWidth = 0
    private val MIN_SCALE = .7f
    private val MAX_SCALE = 1.5f
    private var mMinWidth = 0
    private var mMaxWidth = 0
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }


    override fun initEvent() {

    }

    override fun initView() {
//        aaa.setOnClickListener {
//            Toast.makeText(this,"aaaa",Toast.LENGTH_LONG).show()
//        }
    }

    override fun initData() {
        initBanner()
        initDiscount()
        initNews()
        initViewPager()
        tv_goodstype_pc.setOnClickListener {
            Toast.makeText(this,"电脑",Toast.LENGTH_LONG).show()
        }
        tv_goodstype_live.setOnClickListener {
            Toast.makeText(this,"直播",Toast.LENGTH_LONG).show()
        }
    }

    /**
     * 初始化Banner
     */
    private fun initBanner(){
        banner.setImageLoader(object : ImageLoader(){
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                if (context != null) {
                    if (imageView != null) {
                        Glide.with(context).load(path).into(imageView)
                    }
                }
            }
        })
        banner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_ONE, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        banner.setBannerAnimation(com.youth.banner.Transformer.Accordion)
        banner.setDelayTime(2000)
        banner.setIndicatorGravity(BannerConfig.RIGHT)
        banner.start()
    }

    /**
     * 折扣
     */
    private fun initDiscount(){
        val manager = LinearLayoutManager(this)
        manager.orientation=LinearLayoutManager.HORIZONTAL
        rc.layoutManager=manager

        val discountAdapter = this?.let { HomeDiscountAdapter(it) }
        rc.adapter=discountAdapter
        if (discountAdapter != null) {
            discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE,HOME_DISCOUNT_SIX, HOME_DISCOUNT_SEVEN
            ,HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE,HOME_DISCOUNT_SIX, HOME_DISCOUNT_SEVEN))
        }

    }

    /**
     * 初始化公告
     */
    private fun initNews(){
        news.setData(arrayOf("还有一大波福利快来领取！！！！！！！","注册新用户可以免费领取100元现金红包","奥利给奥利给奥利给"))
    }

    /**
     * 初始化主题
     */
    private fun initViewPager(){
        val manager = LinearLayoutManager(this)
        manager.orientation=LinearLayoutManager.HORIZONTAL
        rv_page.layoutManager = manager
        mScreenWidth = resources.displayMetrics.widthPixels
        mMinWidth = (mScreenWidth * 0.28f).toInt()
        mMaxWidth = mScreenWidth - 2 * mMinWidth
        val names = arrayOfNulls<String>(100)
        for (i in names.indices) {
            names[i] = "name -" + (i + 1)
        }
        val mAdapter = MyAdapter(names)
        rv_page.adapter = mAdapter
        rv_page.addOnScrollListener(mOnScrollListener)
    }

    var mOnScrollListener: RecyclerView.OnScrollListener =
        object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val childCount = recyclerView.childCount
                for (i in 0 until childCount) {
                    val child = recyclerView.getChildAt(i) as RelativeLayout
                    val lp = child.layoutParams as RecyclerView.LayoutParams
                    lp.rightMargin = 150
                    lp.height = 200
                    val left = child.left
                    val right = mScreenWidth - child.right
                    val percent: Float = if (left < 0 || right < 0) 0F else Math.min(left,
                        right) * 1f / Math.max(left, right)
                    val scaleFactor: Float = MIN_SCALE + Math.abs(percent) * (MAX_SCALE - MIN_SCALE)
                    val width = (mMinWidth + Math.abs(percent) * (mMaxWidth - mMinWidth)).toInt()
                    lp.width = width
                    child.layoutParams = lp
                    child.scaleY = scaleFactor
                    if (percent > 1f / 2) {
                        (child.getChildAt(1) as TextView).setTextColor(Color.BLUE)
                    } else {
                        (child.getChildAt(1) as TextView).setTextColor(Color.BLACK)
                    }
                }
            }
        }



}