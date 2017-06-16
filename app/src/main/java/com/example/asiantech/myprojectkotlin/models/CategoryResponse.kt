package com.example.asiantech.myprojectkotlin.models

import com.google.gson.annotations.SerializedName

/**
 * ResponseCategory
 *
 * @author at-ToanNguyen
 */
class CategoryResponse(var data: List<Category>) {
    inner class Category(
            @SerializedName("id_category")
            var idCategory: String
            , @SerializedName("name_category")
            var nameCategory: String
            , @SerializedName("src_img_category")
            var imgCategory: String) {
    }
}