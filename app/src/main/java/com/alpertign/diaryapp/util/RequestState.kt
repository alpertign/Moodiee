package com.alpertign.diaryapp.util

/**
 * Created by Alperen Acikgoz on 01,August,2023
 */
sealed class RequestState<out T>{
    object Idle : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
    data class Error(val error: Throwable): RequestState<Nothing>()
}
