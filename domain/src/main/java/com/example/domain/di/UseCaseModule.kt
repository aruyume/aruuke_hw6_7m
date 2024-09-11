package com.example.domain.di

import com.example.domain.usecase.DeleteTaskUseCase
import com.example.domain.usecase.FetchTasksUseCase
import com.example.domain.usecase.GetTaskUseCase
import com.example.domain.usecase.InsertTaskUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {

    factory { InsertTaskUseCase(get()) }
    factory { GetTaskUseCase(get()) }
    factory { DeleteTaskUseCase(get()) }
    factory { FetchTasksUseCase(get()) }
}