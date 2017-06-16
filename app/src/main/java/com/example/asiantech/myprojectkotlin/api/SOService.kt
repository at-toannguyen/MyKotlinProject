package com.example.asiantech.myprojectkotlin.api

import com.example.asiantech.myprojectkotlin.models.CategoryResponse
import com.example.asiantech.myprojectkotlin.models.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * SOService
 *
 * @author at-ToanNguyen
 */
interface SOService {
    @GET("/get-danh-muc")
    fun getCategory(): Call<CategoryResponse>

    @GET("/get-all-news")
    fun getAllNews(): Call<NewsResponse>

    @GET("/get-news")
    fun getNews(@Query("id") id_new: String): Call<NewsResponse>
}