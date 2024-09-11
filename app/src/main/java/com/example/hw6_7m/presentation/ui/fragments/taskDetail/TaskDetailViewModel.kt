package com.example.hw6_7m.presentation.ui.fragments.taskDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.TaskModel
import com.example.domain.usecase.GetTaskUseCase
import kotlinx.coroutines.Dispatchers

class TaskDetailViewModel(
    private val getTaskUseCase: GetTaskUseCase
) : ViewModel() {

    fun getTaskById(taskId: Int): LiveData<TaskModel?> = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emit(getTaskUseCase(taskId))
    }
}