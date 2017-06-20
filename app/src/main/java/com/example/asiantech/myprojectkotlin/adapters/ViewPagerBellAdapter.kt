package com.example.asiantech.myprojectkotlin.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.asiantech.myprojectkotlin.fragments.BellFollowMyPostFragment
import com.example.asiantech.myprojectkotlin.fragments.BellMyNotificationFragment

/**
 * ViewPagerBellAdapter
 *
 * @author at-ToanNguyen
 */
class ViewPagerBellAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return BellMyNotificationFragment()
            1 -> return BellFollowMyPostFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }
}