package com.example.domain.usecase

import com.example.domain.repository.TaskRepository

class FetchTasksUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke() = taskRepository.fetchTasks()
}