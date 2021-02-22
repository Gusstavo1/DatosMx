package com.gcr.datosmx.data.repositories

import com.gcr.datosmx.data.api.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getGasPrice() = apiHelper.getGasPrice()
    suspend fun getCicloEscolarInfo() = apiHelper.getCicloEscolarInfo()
    //suspend fun getDesempleoInfo() = apiHelper.getDesempleoInfo()
    //suspend fun getPoblacionInfo() = apiHelper.getPoblacionInfo()
    suspend fun getGeneralNews() = apiHelper.getGeneralNews()
}