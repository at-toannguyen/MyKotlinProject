package com.example.asiantech.myprojectkotlin.api

import com.example.asiantech.myprojectkotlin.models.CategoryResponse
import com.example.asiantech.myprojectkotlin.models.NewsDetailResponse
import com.example.asiantech.myprojectkotlin.models.NewsResponse
import com.example.asiantech.myprojectkotlin.models.StatusResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
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
    fun getNews(@Query(Parameter.ID) id_new: String): Call<NewsResponse>

    @GET("/get-detail")
    fun getNewsDetail(@Query(Parameter.ID) idNewsDetail: String): Call<NewsDetailResponse>

    @POST("/saveFavorite")
    fun saveFavorite(@Query(Parameter.ID_NEWS) idNew: String,
                     @Query(Parameter.ID_USER) idUser: String): Call<StatusResponse>

    @POST("/deleteFavorite")
    fun deleteFavorite(@Query(Parameter.ID_NEWS) idNew: String,
                       @Query(Parameter.ID_USER) idUser: String): Call<StatusResponse>
}