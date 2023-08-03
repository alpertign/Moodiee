package com.alpertign.diaryapp.data.repository

import com.alpertign.diaryapp.model.Diary
import com.alpertign.diaryapp.util.RequestState
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

/**
 * Created by Alperen Acikgoz on 01,August,2023
 */

typealias Diaries = RequestState<Map<LocalDate,List<Diary>>>
interface MongoRepository {
    fun configureTheRealm()
    fun getAllDiaries(): Flow<Diaries>
}