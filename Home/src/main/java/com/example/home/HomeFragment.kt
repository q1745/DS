package com.example.home

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.home.adapter.HomeDiscountAdapter
import com.example.home.adapter.MyAdapter
import com.example.home.adapter.ShopAdapter
import com.example.home.common.*
import com.example.home.mvp.injection.component.DaggerShopComponent
import com.example.home.mvp.injection.component.ShopComponent
import com.example.home.mvp.injection.module.ViewModule
import com.example.home.mvp.model.entity.ShopEntity
import com.example.home.mvp.presenter.ShopPresenter
import com.example.home.mvp.view.ShopView
import com.example.mvpcore.view.BaseFragment
import com.example.mvpcore.view.MVPFragment
import com.example.protocol.BaseReposEntity
import com.example.util.LogUtil
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout.*
import javax.inject.Inject

/**
@Name:yao
@CreateDate: 2021/9/17 18:37
@ProjectName: DS
@Package: com.example.home
@ClassName: HomeFragment
 */
class HomeFragment :MVPFragment(),ShopView{



    private var mScreenWidth = 0
    private val MIN_SCALE = .7f
    private val MAX_SCALE = 1.5f
    private var mMinWidth = 0
    private var mMaxWidth = 0

    @Inject
    lateinit var shopPresenter: ShopPresenter
    var homeComponent: ShopComponent? = null

    lateinit var shopAdapter: ShopAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        //商品列表样式
        shop_rec.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

    }

    override fun initInjection() {
        homeComponent = DaggerShopComponent.builder().activityComponent(activityComponent)
            .viewModule(ViewModule(this))
            .build()
        homeComponent!!.injectShopComponent(this)
        shopPresenter.getShop(1)
    }

    override fun initData() {
        initBanner()
        initDiscount()
        initNews()
        initViewPager()
        tv_goodstype_pc.setOnClickListener {
            Toast.makeText(context,"电脑",Toast.LENGTH_LONG).show()
        }
        tv_goodstype_live.setOnClickListener {
            Toast.makeText(context,"直播",Toast.LENGTH_LONG).show()
        }
    }

    override fun initEvent() {

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
        val manager = LinearLayoutManager(context)
        manager.orientation=LinearLayoutManager.HORIZONTAL
        rc.layoutManager=manager

        val discountAdapter  = HomeDiscountAdapter(requireActivity())
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
        val manager = LinearLayoutManager(context)
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

    override fun shopSuccess(entity: BaseReposEntity<ShopEntity>) {
        shopAdapter = ShopAdapter(entity.data)
        shop_rec.adapter = shopAdapter
    }

    override fun shopFailed(throwable: Throwable) {
    }


}