package com.example.spacex.ui.all_launches

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.spacex.common.SortType
import com.example.spacex.common.utils.SchedulerProvider
import com.example.spacex.common.utils.SingleLiveEvent
import com.example.spacex.data.ErrorMessage
import com.example.spacex.data.RocketDataItem
import com.example.spacex.repository.RocketRepository
import com.example.spacex.ui.base.BaseViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class AllLaunchesViewModel(
    private val repository: RocketRepository,
    private val scheduler: SchedulerProvider
) : BaseViewModel() {
    val clickLiveEvent = SingleLiveEvent<Int>()
    val sortTypeText = MutableLiveData(SortType.SORT.resString)
    val notifyEvent by lazy { MutableLiveData<Unit>() }
    val lunchesList = arrayListOf<RocketDataItem>()
    val sortTypeFlow = MutableStateFlow(SortType.SORT)

    init {
        viewModelScope.launch {
            sortTypeFlow
                .debounce(500)
                .collectLatest { type ->
                    getRocketLaunches(sortType = type)
                }
        }
    }

    fun onClick(v: View) {
        clickLiveEvent.postValue(v.id)
    }

    fun getRocketLaunches(sortType: SortType) {
        isLoading.postValue(true)

        viewModelScope.launch {
            repository.getRocketLaunches()
                .flowOn(scheduler.io())
                .catch { e ->
                    Log.e("[API Catch Error]", e.message.orEmpty())
                }
                .collect { response ->
                    response.apply {
                        if (isSuccessful) {
                            body()?.let { rocketList ->
                                lunchesList.clear()

                                when (sortType) {
                                    SortType.SORT -> {
                                        lunchesList.addAll(rocketList.sortedBy { it.flightNumber })
                                    }
                                    SortType.REVERSED -> {
                                        lunchesList.addAll(rocketList.sortedByDescending { it.flightNumber })
                                    }
                                }
                                notifyEvent.postValue(Unit)
                            }
                        } else {
                            errorEvent.postValue(
                                ErrorMessage(
                                    errorCode = code(),
                                    errorMsg = errorBody().toString()
                                )
                            )

                            Log.e("[API Error]", "(${code()}) ${errorBody().toString()}")
                        }
                    }
                }
            isLoading.postValue(false)
        }
    }
}