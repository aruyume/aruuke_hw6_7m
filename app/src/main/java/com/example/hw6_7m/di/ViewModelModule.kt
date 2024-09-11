package com.example.hw6_7m.di

import com.example.hw6_7m.presentation.ui.fragments.taskDetails.TaskDetailsViewModel
import com.example.hw6_7m.presentation.ui.fragments.taskList.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { TaskDetailsViewModel(get())}
    viewModel { TaskViewModel(get(), get(), get())}
}