package com.gcr.datosmx.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.gcr.datosmx.data.repositories.Repository

class NewsViewModel(private val repository: Repository): ViewModel() {

    /*
    private val TAG = "New"

    fun getGeneralNews() = liveData(Dispatchers.IO) {
        emit(com.gcr.datosmx.utils.Resource.loading(data = null))
        try {
            emit(com.gcr.datosmx.utils.Resource.success(data = repository.getGeneralNews()))
            Log.d(TAG, "Success")
        } catch (exception: Exception) {
            Log.d(TAG, "Error: ${exception.message}")
            emit(com.gcr.datosmx.utils.Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }*/
}