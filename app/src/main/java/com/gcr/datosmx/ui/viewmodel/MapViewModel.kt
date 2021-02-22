package com.gcr.datosmx.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gcr.datosmx.data.models.Place
import com.gcr.datosmx.data.repositories.MapRepository
import kotlinx.coroutines.launch

class MapViewModel(private val mapRepository: MapRepository): ViewModel() {

    val coordinates = MutableLiveData<List<Place>>()

    init {
        coordinates.value = mapRepository.getPyramidsCoordinates()
    }

    fun setBeaches(){
        coordinates.value = mapRepository.getBeachesCoordinates()
    }

    fun setMuseums(){
        coordinates.value = mapRepository.getMuseumsCoordinates()
    }

    fun setPyramides(){
        viewModelScope.launch {
            coordinates.value = mapRepository.getPyramidsCoordinates()
        }
    }
}