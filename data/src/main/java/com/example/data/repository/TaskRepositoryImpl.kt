package com.example.data.repository

import com.example.data.db.dao.TaskDao
import com.example.data.model.toDomain
import com.example.data.model.toEntity
import com.example.domain.model.TaskModel
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    override suspend fun insertTask(taskModel: TaskModel) =
        taskDao.insertTask(taskModel.toEntity())

    override suspend fun getTaskById(taskId: Int): TaskModel? {
        return taskDao.getTaskById(taskId)?.toDomain()
    }

    override suspend fun deleteTask(taskId: Long) {
        taskDao.deleteTask(taskId)
    }

    override fun fetchTasks(): Flow<List<TaskModel>> {
        return taskDao.fetchTasks().map { taskList ->
            taskList.map { it.toDomain() }
        }
    }
}