package com.example.asiantech.myprojectkotlin.utils

import com.example.asiantech.myprojectkotlin.api.RetrofitClient
import com.example.asiantech.myprojectkotlin.api.SOService

/**
 * APIClientUtil
 *
 * @author at-ToanNguyen
 */
class MyAPIUtil {
    companion object {
        fun getSOService(): SOService {
            return RetrofitClient.getClient().create(SOService::class.java)
        }
    }
}