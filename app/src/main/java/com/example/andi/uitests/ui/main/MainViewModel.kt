package com.example.andi.uitests.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import org.koin.standalone.KoinComponent

class MainViewModel : ViewModel(), KoinComponent {

    val guysList = MutableLiveData<List<String>>()

    fun fetchData() {
        guysList.value = listOf("Tibisor", "Alinuts", "Vasilica", "Bogdanel")
    }

}