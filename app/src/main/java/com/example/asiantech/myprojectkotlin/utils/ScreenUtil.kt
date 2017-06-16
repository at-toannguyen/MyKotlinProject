package com.example.asiantech.myprojectkotlin.utils

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics

/**
 * ScreenUtil
 * This class use to get screen's width/height
 * @author at-ToanNguyen
 */
class ScreenUtil {
    companion object {

        fun getScreenWidth(context: Context): Int {
            val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.widthPixels
        }

        fun getScreenHeight(context: Context): Int {
            val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.heightPixels
        }
    }
}