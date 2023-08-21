package com.alpertign.diaryapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alpertign.diaryapp.data.database.entity.ImageToDelete
import com.alpertign.diaryapp.data.database.entity.ImageToUpload

/**
 * Created by Alperen Acikgoz on 15,August,2023
 */
@Database(
    entities = [ImageToUpload::class,ImageToDelete::class],
    version = 2,
    exportSchema = false
)
abstract class ImagesDatabase: RoomDatabase() {
    abstract fun imageToUploadDao(): ImageToUploadDao
    abstract fun imageToDeleteDao(): ImageToDeleteDao
}