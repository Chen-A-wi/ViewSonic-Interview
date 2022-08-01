package com.example.spacex.ui.all_launches

import android.util.Log
import android.view.View
import androidx.lifecycle.viewModelScope
import com.example.spacex.common.utils.SchedulerProvider
import com.example.spacex.common.utils.SingleLiveEvent
import com.example.spacex.data.ErrorMessage
import com.example.spacex.repository.RocketRepository
import com.example.spacex.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class AllLaunchesViewModel(
    private val repository: RocketRepository,
    private val scheduler: SchedulerProvider
) : BaseViewModel() {
    val clickLiveEvent = SingleLiveEvent<Int>()

    init {
        getRocketLaunches()
    }

    fun onClick(v: View) {
        clickLiveEvent.postValue(v.id)
    }

    private fun getRocketLaunches() {
        isLoading.postValue(true)

        viewModelScope.launch {
            repository.getRocketLaunches()
                .flowOn(scheduler.io())
                .catch { e ->
                    Log.e("API Catch Error", e.message.orEmpty())
                    errorEvent.postValue(ErrorMessage(errorMsg = e.message.orEmpty()))
                }
                .collect { response ->
                    response.apply {
                        if (isSuccessful) {
                            Log.d("=============", "${body()}")
                        } else {
                            errorEvent.postValue(
                                ErrorMessage(
                                    errorCode = code(),
                                    errorMsg = errorBody().toString()
                                )
                            )

                            Log.e(
                                "API Error",
                                "(${code()}) ${errorBody().toString()}"
                            )
                        }
                    }
                }
            isLoading.postValue(false)
        }
    }
}