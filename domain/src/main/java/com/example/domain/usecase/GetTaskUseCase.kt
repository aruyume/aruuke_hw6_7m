package com.example.domain.usecase

import com.example.domain.model.TaskModel
import com.example.domain.repository.TaskRepository

class GetTaskUseCase(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(taskId: Int): TaskModel? {
        return taskRepository.getTaskById(taskId)
    }
}