package com.example.asiantech.myprojectkotlin.models

import com.google.gson.annotations.SerializedName

/**
 * NewsDetailResponse
 *
 * @author at-ToanNguyen
 */
class NewsDetailResponse(var data: NewsDetail) {
    inner class NewsDetail(
            @SerializedName("adress")
            var address: String,
            @SerializedName("src_img")
            var srcImgNew: String,
            @SerializedName("day_start")
            var dayStart: String,
            @SerializedName("day_end")
            var dayEnd: String,
            @SerializedName("name_category")
            var nameCategory: String,
            @SerializedName("name_district")
            var nameDistricst: String,
            @SerializedName("name_user")
            var nameUser: String,
            @SerializedName("src_img_user")
            var srcImgUser: String,
            @SerializedName("id_user")
            var idUser: String,
            var content: String,
            var user: String,
            var title: String
    ) {}
}