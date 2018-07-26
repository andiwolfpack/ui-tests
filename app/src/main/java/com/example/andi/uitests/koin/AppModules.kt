package com.example.andi.uitests.koin

import com.example.andi.uitests.ui.main.MainViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object AppModules {

    private val viewModelModule: Module = applicationContext {
        viewModel { MainViewModel() }
    }

    val modules = listOf(viewModelModule)
}