package com.example.ds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem

/**
 * 用来接收底部导航与ViewPager
 */
class MainActivity : AppCompatActivity() {

    lateinit var main_vp: ViewPager
    lateinit var main_bottomBar: BottomNavigationBar
    //用来接收Fragment
    var fragments: MutableList<Fragment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        //绘制布局前换位原来的布局样式
        setTheme(R.style.Theme_DS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        fragments.add(TestFragment())

        //设置ViewPager适配器
        main_vp.adapter = object : FragmentStatePagerAdapter(supportFragmentManager,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            override fun getCount(): Int {
                return fragments.size
            }

            override fun getItem(position: Int): Fragment {
                return fragments.get(position)
            }
        }

        //设置底部导航样式
        main_bottomBar.setActiveColor("#FF9800")
            .setInActiveColor("#A1000000")
            .setMode(BottomNavigationBar.MODE_FIXED)
            .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)

        //设置底部导航内容
        main_bottomBar.addItem(BottomNavigationItem(R.drawable.index,"主页"))
            .addItem(BottomNavigationItem(R.drawable.type,"分类"))
            .addItem(BottomNavigationItem(R.drawable.shop,"购物车"))
            .addItem(BottomNavigationItem(R.drawable.mess,"消息"))
            .addItem(BottomNavigationItem(R.drawable.mine,"我的"))
            .initialise()

        //滑动ViewPager联动底部导航
        main_vp.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
//                main_bottomBar.selectTab(position)
            }

            override fun onPageSelected(position: Int) {
                main_bottomBar.selectTab(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        //底部导航联动ViewPager
        main_bottomBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                main_vp.currentItem = 0
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabReselected(position: Int) {
            }

        })

    }

    private fun init() {
        main_vp = findViewById<ViewPager>(R.id.main_vp)
        main_bottomBar = findViewById<BottomNavigationBar>(R.id.main_bottomBar)
    }
}