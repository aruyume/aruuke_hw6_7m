package com.example.hw6_7m.di

import com.example.data.db.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import androidx.room.Room

val databaseModule: Module = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "task_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().taskDao() }
}