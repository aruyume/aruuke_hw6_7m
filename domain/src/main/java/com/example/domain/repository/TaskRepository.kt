package com.example.domain.repository

import com.example.domain.model.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insertTask(taskModel: TaskModel)
    suspend fun getTaskById(taskId: Int): TaskModel?
    suspend fun deleteTask(taskId: Long)
    fun fetchTasks(): Flow<List<TaskModel>>
}
