package com.alpertign.diaryapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alpertign.diaryapp.util.Constants.IMAGE_TO_UPLOAD_TABLE

/**
 * Created by Alperen Acikgoz on 15,August,2023
 */
@Entity(tableName = IMAGE_TO_UPLOAD_TABLE)
data class ImageToUpload(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val remotePath: String,
    val imageUri : String,
    val sessionUri: String
)
