package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.dao.TaskDao
import com.example.data.model.TaskEntityDto

@Database(entities = [TaskEntityDto::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}
