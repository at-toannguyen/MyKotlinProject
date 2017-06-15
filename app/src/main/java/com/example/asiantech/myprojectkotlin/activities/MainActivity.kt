package com.example.asiantech.myprojectkotlin.activities

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.asiantech.myprojectkotlin.R
import com.example.asiantech.myprojectkotlin.adapters.ViewPagerMainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(), TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {
    // Constant variable
    companion object {
        private val SCREEN_PAGE_LIMIT = 3
        private val TAB1_IS_SELECTED = 0
        private val TAB2_IS_SELECTED = 1
        private val TAB3_IS_SELECTED = 2
        private val TAB4_IS_SELECTED = 3
    }

    private var mTab1: TabLayout.Tab? = null
    private var mTab2: TabLayout.Tab? = null
    private var mTab3: TabLayout.Tab? = null
    private var mTab4: TabLayout.Tab? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayoutMain.addOnTabSelectedListener(this)
        tabLayoutMain.tabGravity = TabLayout.GRAVITY_FILL
        viewPagerMain.adapter = ViewPagerMainAdapter(supportFragmentManager)
        viewPagerMain.offscreenPageLimit = SCREEN_PAGE_LIMIT
        viewPagerMain.addOnPageChangeListener(this)
        initTab()
    }

    /**
     * This method init Tab
     */
    fun initTab() {
        mTab1 = tabLayoutMain.newTab()
        mTab2 = tabLayoutMain.newTab()
        mTab3 = tabLayoutMain.newTab()
        mTab4 = tabLayoutMain.newTab()
        // Set icon tab
        mTab1?.setIcon(R.drawable.ic_home_selector)
        mTab2?.setIcon(R.drawable.ic_bell_selector)
        mTab3?.setIcon(R.drawable.ic_collect_selector)
        mTab4?.setIcon(R.drawable.ic_personal_selector)
        // Add tab
        tabLayoutMain.addTab(mTab1!!)
        tabLayoutMain.addTab(mTab2!!)
        tabLayoutMain.addTab(mTab3!!)
        tabLayoutMain.addTab(mTab4!!)
    }

    /**
     *
     */
    override fun onTabReselected(tab: TabLayout.Tab?) {
        viewPagerMain.currentItem = tab!!.position
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        // No-op
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        // No-op
    }

    override fun onPageScrollStateChanged(state: Int) {
        // No-op
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        // No-op
    }

    override fun onPageSelected(position: Int) {
        when (position) {
            TAB1_IS_SELECTED -> mTab1?.select()
            TAB2_IS_SELECTED -> mTab2?.select()
            TAB3_IS_SELECTED -> mTab3?.select()
            TAB4_IS_SELECTED -> mTab4?.select()
        }
    }

}
