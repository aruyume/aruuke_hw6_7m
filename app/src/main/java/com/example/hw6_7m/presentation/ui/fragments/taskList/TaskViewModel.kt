package com.example.hw6_7m.presentation.ui.fragments.taskList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteTaskUseCase
import com.example.domain.usecase.FetchTasksUseCase
import com.example.domain.usecase.GetTaskUseCase
import kotlinx.coroutines.launch

class TaskViewModel(
    private val getTaskUseCase: GetTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val fetchTasksUseCase: FetchTasksUseCase
) : ViewModel() {

    fun getTaskById(taskId: Int) {
        viewModelScope.launch {
            getTaskUseCase(taskId)
        }
    }

    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            deleteTaskUseCase(taskId)
        }
    }

    suspend fun fetchTasks() = fetchTasksUseCase()
}