package com.gcr.datosmx.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gcr.datosmx.data.repositories.MapRepository

class ViewModelMapFactory(private val mapRepository: MapRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MapRepository::class.java).newInstance(mapRepository)
    }
}