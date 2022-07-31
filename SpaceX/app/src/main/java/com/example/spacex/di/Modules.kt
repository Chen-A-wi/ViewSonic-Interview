package com.example.spacex.di

import com.example.spacex.common.utils.AppSchedulerProvider
import com.example.spacex.common.utils.SchedulerProvider
import com.example.spacex.ui.all_launches.AllLaunchesViewModel
import com.example.spacex.ui.launch_detail.LaunchDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AllLaunchesViewModel() }
    viewModel { LaunchDetailViewModel() }
}

val schedulerModule = module {
    single { AppSchedulerProvider() as SchedulerProvider }
}

val diModules = listOf(viewModelModule, schedulerModule)