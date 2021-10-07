package com.example.goods.ui.fragment

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import com.example.goods.R
import com.example.goods.injection.component.DaggerDetailComponent
import com.example.goods.injection.module.ModelModule
import com.example.goods.injection.module.ViewModule
import com.example.goods.presenter.DetailPresenter
import com.example.goods.service.entity.GoodsDetailEntity
import com.example.goods.ui.DetailView
import com.example.goods.ui.GoodSkuPopView
import com.example.goods.ui.activity.GoodsActivity
import com.example.mvpcore.view.BaseActivity
import com.example.mvpcore.view.MVPFragment
import com.example.util.utils.GlideUtils
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.goods_detail_layout_one.*
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class GoodsDetailOne : MVPFragment() , DetailView{

    @Inject
    lateinit var presenter : DetailPresenter
    //商品弹层
    lateinit var goodSkuPopView: GoodSkuPopView
    //SKU弹层出场动画
    private lateinit var mAnimationStart: Animation
    //SKU弹层退场动画
    private lateinit var mAnimationEnd: Animation
    //Dagger组装
    override fun initInjection() {
        DaggerDetailComponent.builder().activityComponent(activityComponent)
            .modelModule(ModelModule())
            .viewModule(ViewModule(this))
            .build().injectFragment(this)
        presenter.getGoodsDetail((context as GoodsActivity).getGoodsId())
    }

    override fun initEvent() {
        mSkuView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.i("TAG", "onClick: ")
                goodSkuPopView.showAtLocation((activity as GoodsActivity).contentView
                    , Gravity.BOTTOM and Gravity.CENTER_HORIZONTAL,
                    0, 0)
                (activity as BaseActivity).contentView.startAnimation(mAnimationStart)
            }
        })
    }

    override fun initView() {
        initPopupWindow()
        initAnimator()
    }



    override fun initData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.goods_detail_layout_one
    }

    override fun success(bean: GoodsDetailEntity) {
        initBanner(bean.goodsBanner)
        mGoodsDescTv.text = bean.goodsDesc
        mGoodsPriceTv.text = "$${bean.goodsSalesCount}"
        mSkuSelectedTv.text = bean.goodsDefaultSku

        var images : MutableList<String> = mutableListOf(bean.goodsDetailOne,bean.goodsDetailTwo)
        EventBus.getDefault().post(images)
    }

    override fun failed(throwable: Throwable) {

    }

    //设置Banner
    private fun initBanner(goodsBanner: String) {
        val bannerPics:MutableList<String> = goodsBanner.split(",") as MutableList<String>
        mGoodsDetailBanner.setImages(bannerPics)
        mGoodsDetailBanner.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                GlideUtils.loadImage(context!!,path as String,imageView!!)
            }
        })
        mGoodsDetailBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        mGoodsDetailBanner.setBannerAnimation(Transformer.DepthPage)
        //设置自动轮播，默认为true
        mGoodsDetailBanner.isAutoPlay(true)
        //设置轮播时间
        mGoodsDetailBanner.setDelayTime(1500)
        //设置指示器位置（当banner模式中有指示器时）
        mGoodsDetailBanner.setIndicatorGravity(BannerConfig.CENTER)
        //banner设置方法全部调用完毕时最后调用
        mGoodsDetailBanner.start()
    }

    /**
     * 初始化PopupWindow
     */
    fun initPopupWindow(){
        goodSkuPopView = GoodSkuPopView(context as Activity)

        goodSkuPopView.setOnDismissListener {
            (activity as BaseActivity).contentView.startAnimation(mAnimationEnd)
        }
    }
    /**
     * 初始化Activity动画
     */
    private fun initAnimator() {
        mAnimationStart = ScaleAnimation(
            1f, 0.95f, 1f, 0.95f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        mAnimationStart.duration = 500
        mAnimationStart.fillAfter = true

        mAnimationEnd = ScaleAnimation(
            0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        mAnimationEnd.duration = 500
        mAnimationEnd.fillAfter = true
    }
}