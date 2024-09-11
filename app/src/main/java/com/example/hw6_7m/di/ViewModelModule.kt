package com.example.hw6_7m.di

import com.example.hw6_7m.presentation.ui.fragments.taskCreate.TaskCreateViewModel
import com.example.hw6_7m.presentation.ui.fragments.taskDetail.TaskDetailViewModel
import com.example.hw6_7m.presentation.ui.fragments.taskList.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { TaskCreateViewModel(get()) }
    viewModel { TaskViewModel(get(), get()) }
    viewModel { TaskDetailViewModel(get()) }
}