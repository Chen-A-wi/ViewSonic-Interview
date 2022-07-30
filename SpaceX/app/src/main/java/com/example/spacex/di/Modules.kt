package com.example.spacex.di

import com.example.spacex.ui.all_launches.AllLaunchesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AllLaunchesViewModel() }
}

val diModules = listOf(viewModelModule)