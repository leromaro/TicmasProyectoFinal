package com.leromaro.proyectofinal

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val result : LiveData<Result> get() =_result
    private var _result= MutableLiveData<Result>(Result(""))

    fun comparar(text: String, text1: String) {
        val respuesta : String
        if (text.equals(text1)) {
           respuesta = "Los textos son iguales"
        }else{
            respuesta = "Los textos son distintos"
        }
        responder(respuesta)
    }
    fun responder(respuesta : String){
        viewModelScope.launch {
            _result.value = Result(respuesta)
        }
    }
}