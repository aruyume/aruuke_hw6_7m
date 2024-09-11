package com.example.hw6_7m.presentation.ui.fragments.taskDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.InsertTaskUseCase
import com.example.hw6_7m.presentation.models.TaskEntityUi
import com.example.hw6_7m.presentation.models.fromDomain
import kotlinx.coroutines.launch

class TaskDetailsViewModel(
    private val insertTaskUseCase: InsertTaskUseCase,
) : ViewModel() {

    fun insertTask(task: TaskEntityUi) {
        viewModelScope.launch {
            insertTaskUseCase(task.fromDomain())
        }
    }
}