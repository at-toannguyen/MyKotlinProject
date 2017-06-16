package com.example.asiantech.myprojectkotlin.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * RetrofitClient
 *
 * @author at-ToanNguyen
 */
class RetrofitClient {
    companion object {
        private const val BASE_URL = "http://www.salenew.pe.hu"
        private var retrofit: Retrofit? = null
        fun getClient(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }
    }
}