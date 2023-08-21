package com.alpertign.diaryapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alpertign.diaryapp.util.Constants.IMAGE_TO_DELETE_TABLE

/**
 * Created by Alperen Acikgoz on 21,August,2023
 */
@Entity(tableName = IMAGE_TO_DELETE_TABLE)
data class ImageToDelete(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val remoteImagePath: String
)