package com.gcr.datosmx.data.api

import com.gcr.datosmx.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private fun getRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService =
        getRetrofit(Constants.BASE_URL).create(ApiService::class.java)
    val newService: ApiService =
        getRetrofit(Constants.BASE_URL_GRAL_NEWS).create(ApiService::class.java)

}