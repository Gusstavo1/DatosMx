package com.gcr.datosmx.data.api

import com.gcr.datosmx.data.models.responses.gas.ResultGasPrice
import com.gcr.datosmx.data.models.responses.news.MexicoNews
import com.gcr.datosmx.data.models.responses.school.ResultCicloEscolar
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/precio.gasolina.publico")
    suspend fun getGasPrice(): ResultGasPrice

    @GET("v2/SNEDH-9e0cb023-3e34-4768-95a4-9d8512998033")
    suspend fun getCicloEscolarInfo(): ResultCicloEscolar

    //@GET("v2/SNEDH-9cb7a2a2-aff6-4796-a458-cc7aa47241da")
    //suspend fun getDesempleoInfo(): Desempleo

    //@GET("v2/SNEDH-9ca64f8a-8120-4ac6-b2ac-a52da57f837f")
    //suspend fun getPoblacionInfo(): Poblacion

    @GET("v2/top-headlines?country={country}&apiKey={apikey}")
    suspend fun getGeneralNews(
        @Query("country")
        country: String,
        @Query("apiKey")
        key: String
    ): MexicoNews
}