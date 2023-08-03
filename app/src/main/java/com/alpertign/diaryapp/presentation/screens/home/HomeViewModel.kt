package com.alpertign.diaryapp.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpertign.diaryapp.data.repository.Diaries
import com.alpertign.diaryapp.data.repository.MongoDB
import com.alpertign.diaryapp.util.RequestState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.log

/**
 * Created by Alperen Acikgoz on 02,August,2023
 */
class HomeViewModel : ViewModel() {
    var diaries: MutableState<Diaries> = mutableStateOf(RequestState.Idle)

    init {
        observeALlDiaries()
    }
    private fun observeALlDiaries() {
        viewModelScope.launch {
            MongoDB.getAllDiaries().collect() { result ->
                diaries.value = result
                Log.e("HomeViewModel","diaries.value : ${diaries.value}")
            }
        }
    }
}