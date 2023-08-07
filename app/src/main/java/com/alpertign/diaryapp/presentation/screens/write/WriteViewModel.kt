package com.alpertign.diaryapp.presentation.screens.write

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alpertign.diaryapp.model.Mood
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.alpertign.diaryapp.data.repository.MongoDB
import com.alpertign.diaryapp.model.Diary
import com.alpertign.diaryapp.util.Constants.WRITE_SCREEN_ARGUMENT_KEY
import com.alpertign.diaryapp.util.RequestState
import com.alpertign.diaryapp.util.extractBetweenBrackets
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

/**
 * Created by Alperen Acikgoz on 05,August,2023
 */
class WriteViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var uiState by mutableStateOf(UiState())
        private set

    init {
        getDiaryIdArgument()
        fetchSelectedDiary()
    }

    private fun getDiaryIdArgument() {
        uiState = uiState.copy(
            selectedDiaryId = savedStateHandle.get<String>(
                key = WRITE_SCREEN_ARGUMENT_KEY
            )
        )
    }


    private fun fetchSelectedDiary() {
        if (uiState.selectedDiaryId != null) {
            viewModelScope.launch {
                MongoDB.getSelectedDiary(diaryId = ObjectId.invoke(uiState.selectedDiaryId!!))
                    .catch {
                        emit(RequestState.Error(Exception("Diary is already deleted.")))
                    }
                    .collect { diary ->
                        if (diary is RequestState.Success) {
                            setMood(mood = Mood.valueOf(diary.data.mood))
                            setSelectedDiary(diary = diary.data)
                            setTitle(title = diary.data.title)
                            setDescription(description = diary.data.description)


                        }
                    }
            }
        }
    }

    private fun setSelectedDiary(diary: Diary) {
        //uiState = uiState.copy(selectedDiary = diary)
    }

    fun setTitle(title: String) {
        uiState = uiState.copy(
            title = title
        )
    }

    fun setDescription(description: String) {
        uiState = uiState.copy(
            description = description
        )
    }

    fun setMood(mood: Mood) {
        uiState = uiState.copy(
            mood = mood
        )
    }

}

data class UiState(
    val selectedDiaryId: String? = null,
    val title: String = "",
    val description: String = "",
    val mood: Mood = Mood.Neutral
)