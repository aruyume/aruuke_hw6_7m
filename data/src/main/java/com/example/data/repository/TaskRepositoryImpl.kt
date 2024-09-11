package com.example.data.repository

import com.example.data.db.dao.TaskDao
import com.example.data.model.TaskEntityDto
import com.example.data.model.fromDomain
import com.example.data.model.toDomain
import com.example.domain.model.Task
import com.example.domain.model.TaskModel
import com.example.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    override suspend fun insertTask(task: TaskModel) {
        taskDao.insertTask(task.fromDomain())
    }

    override suspend fun getTaskById(taskId: Int): TaskModel? {
        return taskDao.getTaskById(taskId)!!.toDomain()
    }

    override suspend fun deleteTask(taskId: Int) {
        taskDao.deleteTask(taskId)
    }

    override suspend fun fetchTasks(): List<TaskModel> {
        return taskDao.fetchTasks().map { it.toDomain() }
    }
}