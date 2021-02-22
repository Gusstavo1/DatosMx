package com.gcr.datosmx.data.models.responses.gas

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GasPrice (
        val _id: String,
        val calle: String,
        val codigopostal: String,
        val colonia: String,
        val date_insert: String,
        val dieasel: String,
        val fechaaplicacion: String,
        val latitude: String,
        val longitude: String,
        val numeropermiso: String,
        val premium: String,
        val razonsocial: String,
        val regular: String,
        val rfc: String
):Parcelable