package com.example.shaedviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val flavor = MutableLiveData<String>()
    val pounds = MutableLiveData<String>()
    val location = MutableLiveData<String>()

    fun sendFlavor(text: String) {
        flavor.value = text
    }

    fun sendPounds(text: String) {
        pounds.value = text
    }

    fun sendLocation(text: String) {
        location.value = text
    }


}