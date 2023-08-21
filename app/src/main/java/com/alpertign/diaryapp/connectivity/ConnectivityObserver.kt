package com.alpertign.diaryapp.connectivity

import kotlinx.coroutines.flow.Flow

/**
 * Created by Alperen Acikgoz on 21,August,2023
 */
interface ConnectivityObserver {
    fun observe():Flow<Status>
    enum class Status{
        Available, Unavailable, Losing, Lost
    }
}