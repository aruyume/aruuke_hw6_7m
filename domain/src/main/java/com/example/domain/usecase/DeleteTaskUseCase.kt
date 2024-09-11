package com.example.domain.usecase

import com.example.domain.repository.TaskRepository

class DeleteTaskUseCase(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(taskId: Long) {
        taskRepository.deleteTask(taskId)
    }
}