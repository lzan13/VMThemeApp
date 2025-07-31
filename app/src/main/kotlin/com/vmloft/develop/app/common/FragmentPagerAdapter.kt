package com.vmloft.develop.app.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

import java.util.*

/**
 * Created by liyongan on 19/3/5.
 */
class FragmentPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, fragments: ArrayList<Fragment>) : FragmentStateAdapter(fm, lifecycle) {
    private val fragments: ArrayList<Fragment> = fragments

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}