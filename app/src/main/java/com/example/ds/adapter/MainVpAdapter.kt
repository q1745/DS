package com.example.ds.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class MainVpAdapter(var fm: FragmentManager, var br: Int, var list: MutableList<Fragment> ) : FragmentStatePagerAdapter(fm,br){

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }
}