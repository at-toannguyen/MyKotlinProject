package com.example.asiantech.myprojectkotlin.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.asiantech.myprojectkotlin.fragments.CollectMyNewsFragment
import com.example.asiantech.myprojectkotlin.fragments.CollectMySaveFragment

/**
 * ViewPagerCollectAdapter
 *
 * @author at-ToanNguyen
 */
class ViewPagerCollectAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return CollectMyNewsFragment()
            1 -> return CollectMySaveFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

}