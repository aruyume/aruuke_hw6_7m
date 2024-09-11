package com.example.domain.repository

import com.example.domain.model.TaskModel

interface TaskRepository {
    suspend fun insertTask(taskModel: TaskModel)
    suspend fun getTaskById(taskId: Int): TaskModel?
    suspend fun deleteTask(taskId: Int)
    suspend fun fetchTasks() : List<TaskModel>
}