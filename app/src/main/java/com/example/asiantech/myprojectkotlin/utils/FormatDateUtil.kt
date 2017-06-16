package com.example.asiantech.myprojectkotlin.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * FormatDateUtil
 *
 * @author at-ToanNguyen
 */
class FormatDateUtil{
    companion object{
        fun formatDate(dateString:String): String? {
            val input: SimpleDateFormat= SimpleDateFormat("yyyy-MM-dd");
            val date:Date=input.parse(dateString)
            val output:SimpleDateFormat=SimpleDateFormat("dd/MM/yyyy")
            return output.format(date)
        }
    }
}