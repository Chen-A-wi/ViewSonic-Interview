package com.example.spacex.data

import android.content.Context
import com.example.spacex.common.ErrorType

data class ErrorMessage(
    val errorCode: Int = -1,
    val errorMsg: String = ""
) {
    fun message(context: Context): String {
        return if (errorCode == -1) {
            "(${context.getString(ErrorType.fromCode(errorCode).resString)}) $errorMsg"
        } else {
            "(${errorCode}) $errorMsg"
        }
    }
}

