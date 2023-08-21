package com.alpertign.diaryapp.presentation.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpertign.diaryapp.data.repository.Diaries
import com.alpertign.diaryapp.data.repository.MongoDB
import com.alpertign.diaryapp.model.RequestState
import kotlinx.coroutines.launch

/**
 * Created by Alperen Acikgoz on 02,August,2023
 */
class HomeViewModel : ViewModel() {
    var diaries: MutableState<Diaries> = mutableStateOf(RequestState.Idle)

    init {
        observeAllDiaries()
    }
    private fun observeAllDiaries() {
        viewModelScope.launch {
            MongoDB.getAllDiaries().collect() { result ->
                diaries.value = result
            }
        }
    }
}