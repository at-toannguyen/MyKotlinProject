package com.example.asiantech.myprojectkotlin.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.asiantech.myprojectkotlin.fragments.BellFragment
import com.example.asiantech.myprojectkotlin.fragments.CollectFragment
import com.example.asiantech.myprojectkotlin.fragments.HomeFragment
import com.example.asiantech.myprojectkotlin.fragments.PersonalFragment

/**
 * AdapterViewPagerMain
 *
 * @author at-ToanNguyen
 */
class ViewPagerMainAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return HomeFragment()
            1 -> return CollectFragment()
            2 -> return BellFragment()
            3 -> return PersonalFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 4;
    }
}