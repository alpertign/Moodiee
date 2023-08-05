package com.alpertign.diaryapp.presentation.screens.write

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alpertign.diaryapp.model.Mood
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.alpertign.diaryapp.util.Constants.WRITE_SCREEN_ARGUMENT_KEY

/**
 * Created by Alperen Acikgoz on 05,August,2023
 */
class WriteViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    var uiState by mutableStateOf(UiState())
        private set

    init {
        getDiaryIdArgument()
    }
    private fun getDiaryIdArgument(){
        uiState = uiState.copy(
            selectedDiaryId = savedStateHandle.get<String>(
                key = WRITE_SCREEN_ARGUMENT_KEY
            )
        )
    }

}

data class UiState(
    val selectedDiaryId: String? = null,
    val title: String = "",
    val description: String = "",
    val mood: Mood = Mood.Neutral
)