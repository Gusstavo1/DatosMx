package com.gcr.datosmx.data.api

import com.gcr.datosmx.utils.Constants

class ApiHelper(private val apiService: ApiService) {
    suspend fun getGasPrice() = apiService.getGasPrice()
    suspend fun getCicloEscolarInfo() = apiService.getCicloEscolarInfo()
    //suspend fun getDesempleoInfo() = apiService.getDesempleoInfo()
    //suspend fun getPoblacionInfo() = apiService.getPoblacionInfo()
    suspend fun getGeneralNews() = apiService.getGeneralNews("mx", Constants.API_KEY)
}