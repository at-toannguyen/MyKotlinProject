package com.example.asiantech.myprojectkotlin.models

import com.google.gson.annotations.SerializedName

/**
 * NewsResponse
 *
 * @author at-ToanNguyen
 */
class NewsResponse(var data: List<News>) {
    inner class News(
            @SerializedName("id_new")
            var idNews: String
            , @SerializedName("title")
            var titleNews: String
            , @SerializedName("content")
            var contentNews: String
            , @SerializedName("day_start")
            var dayStart: String
            , @SerializedName("day_end")
            var dayEnd: String
            , @SerializedName("src_img")
            var srcImage: String
    ) {}
}