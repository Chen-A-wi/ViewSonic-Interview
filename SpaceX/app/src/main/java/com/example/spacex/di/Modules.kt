package com.example.spacex.di

import com.example.spacex.api.Config
import com.example.spacex.api.RocketServices
import com.example.spacex.common.MoshiArrayListJsonAdapter
import com.example.spacex.common.utils.AppSchedulerProvider
import com.example.spacex.common.utils.LoggerInterceptor
import com.example.spacex.common.utils.SchedulerProvider
import com.example.spacex.data.RocketDataItem
import com.example.spacex.repository.RocketRepository
import com.example.spacex.ui.all_launches.AllLaunchesViewModel
import com.example.spacex.ui.all_launches.bottom_sheet_dialog.SortBottomSheetDialogViewModel
import com.example.spacex.ui.launch_detail.LaunchDetailViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel { AllLaunchesViewModel(get(), get()) }
    viewModel { (rocketDataItem: RocketDataItem) -> LaunchDetailViewModel(rocketDataItem) }
    viewModel { SortBottomSheetDialogViewModel() }
}

val schedulerModule = module {
    single { AppSchedulerProvider() as SchedulerProvider }
}

val networkModule = module {
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(MoshiArrayListJsonAdapter.FACTORY)
            .build()
    }
    single { createOkHttpClient() }
    single { createService<RocketServices>(get(), get(), Config.URL) }
}

val repositoryModule = module {
    single { RocketRepository(get()) }
}

val diModules = listOf(schedulerModule, networkModule, repositoryModule, viewModelModule)

fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .addNetworkInterceptor(LoggerInterceptor())
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
        .build()
}

inline fun <reified T> createService(
    okHttpClient: OkHttpClient,
    moshi: Moshi,
    serverUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(serverUrl)                                             //設定請求URL
        .client(okHttpClient)                                           //設定OkHttp攔截器
        .addConverterFactory(MoshiConverterFactory.create(moshi))       //設定解析工具
        .build()

    return retrofit.create(T::class.java)
}