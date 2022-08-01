package com.example.spacex.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex.common.utils.SingleLiveEvent
import com.example.spacex.data.ErrorMessage

abstract class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val errorEvent by lazy { SingleLiveEvent<ErrorMessage>() }
}
