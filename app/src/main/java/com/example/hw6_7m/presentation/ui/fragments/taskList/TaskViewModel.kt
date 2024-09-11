package com.example.hw6_7m.presentation.ui.fragments.taskList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteTaskUseCase
import com.example.domain.usecase.FetchTasksUseCase
import com.example.hw6_7m.presentation.models.TaskEntityUi
import com.example.hw6_7m.presentation.models.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TaskViewModel(
    private val getTaskUseCase: FetchTasksUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    fun deleteTask(taskId: Long) {
        viewModelScope.launch {
            deleteTaskUseCase(taskId)
        }
    }

    fun getTasks(): Flow<List<TaskEntityUi>> {
        return getTaskUseCase()
            .map { taskModels ->
                taskModels.map { it.toUi() }
            }
    }
}