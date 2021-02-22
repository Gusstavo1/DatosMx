package com.gcr.datosmx.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gcr.datosmx.data.repositories.Repository
import com.gcr.datosmx.utils.GetLocalTime
import com.gcr.datosmx.utils.Response
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repository: Repository) : ViewModel() {

    val hour = MutableLiveData<Int>()

    fun getGasPrice() = liveData(Dispatchers.IO) {
        emit(com.gcr.datosmx.utils.Resource.loading(data = null))
        try {
            emit(com.gcr.datosmx.utils.Resource.success(data = repository.getGasPrice()))
            Log.d("VM", "Success")
        } catch (exception: Exception) {
            Log.d("VM", "Error: ${exception.message}")
            emit(com.gcr.datosmx.utils.Resource.error(exception.message.toString(),""))
        }
    }

    fun getCicloEscolarInfo() = liveData(Dispatchers.IO){
        emit(Response.success(data = null))
        try {
            emit(Response.success(data = repository.getCicloEscolarInfo()))
        } catch (exception: Exception) {
            Log.d("VM", "Error: ${exception.message}")
            emit(Response.error(exception.toString(),""))
        }
    }

    /*fun getDesempleoInfo() = liveData(Dispatchers.IO){
        emit(com.gcr.datosmx.utils.Resource.loading(data = null))
        try {
            emit(com.gcr.datosmx.utils.Resource.success(data = repository.getDesempleoInfo()))
        } catch (exception: Exception) {
            Log.d("VM", "Error: ${exception.message}")
            emit(com.gcr.datosmx.utils.Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getPoblacionInfo() = liveData(Dispatchers.IO){
        emit(com.gcr.datosmx.utils.Resource.loading(data = null))
        try {
            emit(com.gcr.datosmx.utils.Resource.success(data = repository.getPoblacionInfo()))
        } catch (exception: Exception) {
            Log.d("VM", "Error: ${exception.message}")
            emit(com.gcr.datosmx.utils.Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }*/

    fun getGreeting(){
        hour.value = GetLocalTime.getHour()
    }
}


