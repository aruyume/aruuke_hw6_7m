package com.example.domain.repository

import com.example.domain.model.Task

interface TaskRepository {
    suspend fun insertTask(task: Task)
    suspend fun getTaskById(taskId: Int): Task?
    suspend fun deleteTask(taskId: Int)
}