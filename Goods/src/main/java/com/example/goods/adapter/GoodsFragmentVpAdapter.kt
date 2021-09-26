package com.example.goods.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class GoodsFragmentVpAdapter(fm: FragmentManager, behavior: Int,
                             var fragments:MutableList<Fragment>,var titles:MutableList<String>) : FragmentStatePagerAdapter(fm,behavior){


    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }
}