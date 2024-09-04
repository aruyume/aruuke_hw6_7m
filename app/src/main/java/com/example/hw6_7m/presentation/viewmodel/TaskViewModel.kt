package com.example.hw6_7m.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Task
import com.example.domain.usecase.DeleteTaskUseCase
import com.example.domain.usecase.GetTaskUseCase
import com.example.domain.usecase.InsertTaskUseCase
import kotlinx.coroutines.launch

class TaskViewModel(
    private val insertTaskUseCase: InsertTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    fun insertTask(task: Task) {
        viewModelScope.launch {
            insertTaskUseCase.execute(task)
        }
    }

    fun getTaskById(taskId: Int) {
        viewModelScope.launch {
            getTaskUseCase.execute(taskId)
        }
    }

    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            deleteTaskUseCase.execute(taskId)
        }
    }
}