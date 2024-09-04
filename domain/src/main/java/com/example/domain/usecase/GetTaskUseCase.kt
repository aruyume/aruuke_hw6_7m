package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class GetTaskUseCase(private val taskRepository: TaskRepository) {
    suspend fun execute(taskId: Int): Task? {
        return taskRepository.getTaskById(taskId)
    }
}