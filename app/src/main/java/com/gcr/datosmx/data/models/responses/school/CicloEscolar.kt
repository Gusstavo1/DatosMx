package com.gcr.datosmx.data.models.responses.school

import com.google.gson.annotations.SerializedName

data class CicloEscolar(
    val _id: String,
    val desglose: String,
    @SerializedName("ciclo-escolar")
    val cicloEscolar: String,
    @SerializedName("num-esc")
    val numEscuela: String
)