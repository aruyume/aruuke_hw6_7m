package com.example.hw6_7m.di

import com.example.hw6_7m.presentation.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { TaskViewModel(get(), get(), get()) }
}