package com.example.andi.uitests.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import org.koin.standalone.KoinComponent

class MainViewModel : ViewModel(), KoinComponent {

    val guysList = MutableLiveData<List<String>>()

    fun fetchData() {
        if (guysList.value?.isEmpty() ?: return) {
            val baietii = listOf("Tibisor", "Alinuts", "Vasilica", "Bogdanel")
            guysList.value = baietii
        }
    }

}