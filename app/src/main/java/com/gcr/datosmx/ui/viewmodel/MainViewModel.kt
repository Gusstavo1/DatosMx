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

    fun getGasPrice() = liveData(Dispatchers.IO){
        emit(Response.loading(data = null))
        try {
           emit(Response.success(data = repository.getGasPrice()))
       } catch (exception:java.lang.Exception){
           emit(Response.error(exception.message.toString(),null))
            Log.d("VM", "Error: ${exception.message}")
       }
    }

    fun getCicloEscolarInfo() = liveData(Dispatchers.IO){
        emit(Response.loading(data = null))
        try {
            emit(Response.success(data = repository.getCicloEscolarInfo()))
        } catch (exception:java.lang.Exception){
            emit(Response.error(exception.message.toString(),null))
            Log.d("VM", "Error: ${exception.message}")
        }
    }

    fun getGreeting(){
        hour.value = GetLocalTime.getHour()
    }
}


