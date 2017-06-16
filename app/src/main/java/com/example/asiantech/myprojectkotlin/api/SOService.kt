package com.example.asiantech.myprojectkotlin.api

import com.example.asiantech.myprojectkotlin.models.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * SOService
 *
 * @author at-ToanNguyen
 */
interface SOService {
    @GET("/get-danh-muc")
    fun getCategory(): Call<CategoryResponse>

}