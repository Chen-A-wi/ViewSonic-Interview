package com.example.spacex.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.example.searchdemo.common.utils.SingleLiveEvent
//import com.example.searchdemo.data.ErrorMessage
import com.example.spacex.common.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
//    val errorEvent by lazy { SingleLiveEvent<ErrorMessage>() }
}
