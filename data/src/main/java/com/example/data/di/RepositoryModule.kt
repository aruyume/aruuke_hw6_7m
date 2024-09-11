package com.example.data.di

import com.example.data.repository.TaskRepositoryImpl
import com.example.domain.repository.TaskRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single<TaskRepository> {
        TaskRepositoryImpl(get())
    }
}