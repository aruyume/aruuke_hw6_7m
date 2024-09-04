package com.example.data.repository

import com.example.data.db.dao.TaskDao
import com.example.data.model.TaskEntity
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }

    override suspend fun getTaskById(taskId: Int): Task? {
        return taskDao.getTaskById(taskId)?.toDomain()
    }

    override suspend fun deleteTask(taskId: Int) {
        taskDao.deleteTask(taskId)
    }

    private fun Task.toEntity(): TaskEntity {
        return TaskEntity(
            taskId = this.taskId,
            taskName = this.taskName
        )
    }

    private fun TaskEntity.toDomain(): Task {
        return Task(
            taskId = this.taskId,
            taskName = this.taskName
        )
    }
}