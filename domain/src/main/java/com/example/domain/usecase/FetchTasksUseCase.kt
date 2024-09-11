package com.example.domain.usecase

import com.example.domain.model.TaskModel
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class FetchTasksUseCase(private val taskRepository: TaskRepository) {

    operator fun invoke(): Flow<List<TaskModel>> = taskRepository.fetchTasks()
}