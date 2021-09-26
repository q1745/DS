package com.example.home.common

import android.content.Context
import android.view.View
import androidx.annotation.DimenRes

/**
@Name:yao
@CreateDate: 2021/9/17 19:02
@ProjectName: DS
@Package: com.example.home.common
@ClassName: Constan
 */

/*
 * 首页Banner
 */
const val HOME_BANNER_ONE = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=259364631,2307942273&fm=26&gp=0.jpg"
const val HOME_BANNER_TWO = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3765821666,4235344830&fm=26&gp=0.jpg"
const val HOME_BANNER_THREE = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3336810809,2729597475&fm=26&gp=0.jpg"
const val HOME_BANNER_FOUR = "http://vueshop.glbuys.com/uploadfiles/1524206455.jpg"


/*
   首页折扣图片
 */
const val HOME_DISCOUNT_ONE = "https://img14.360buyimg.com/n0/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg"
const val HOME_DISCOUNT_TWO = "https://img10.360buyimg.com/n7/jfs/t5905/106/1120548052/61075/6eafa3a5/592f8f7bN763e3d30.jpg"
const val HOME_DISCOUNT_THREE = "https://img10.360buyimg.com/n7/jfs/t5584/99/6135095454/371625/423b9ba5/59681d91N915995a7.jpg"
const val HOME_DISCOUNT_FOUR = "https://img11.360buyimg.com/n7/jfs/t4447/301/1238553109/193354/13c7e995/58db19a7N25101fe4.jpg"
const val HOME_DISCOUNT_FIVE = "https://img14.360buyimg.com/n1/s190x190_jfs/t7525/189/155179632/395056/e200017f/598fb8a4N7800dee6.jpg"
const val HOME_DISCOUNT_SIX = "https://img10.360buyimg.com/n7/jfs/t5584/99/6135095454/371625/423b9ba5/59681d91N915995a7.jpg"
const val HOME_DISCOUNT_SEVEN = "https://img14.360buyimg.com/n0/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg"

fun Context.px2sp(px: Int): Float = px.toFloat() / resources.displayMetrics.scaledDensity
fun Context.dimen(@DimenRes resource: Int): Int = resources.getDimensionPixelSize(resource)

inline fun View.px2sp(px: Int): Float = context.px2sp(px)
inline fun View.dimen(@DimenRes resource: Int): Int = context.dimen(resource)
