package com.example.iiflprojecttask

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.iiflprojecttask.views.TabOneFragment
import com.example.iiflprojecttask.views.TabThreeFragment
import com.example.iiflprojecttask.views.TabTwoFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TabOneFragment()
            }
            1 -> TabTwoFragment()
            else -> {
                return TabThreeFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> {
                return "Third Tab"
            }
        }
    }
}