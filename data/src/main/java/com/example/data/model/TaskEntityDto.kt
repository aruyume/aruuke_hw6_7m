package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.TaskModel

@Entity(tableName = "task_table")
data class TaskEntityDto(
    @PrimaryKey(autoGenerate = true) val taskId: Long = 0,
    val taskName: String,
    val description: String,
    val time: Long
)

fun TaskEntityDto.toDomain() = TaskModel(taskId, taskName, description, time)

fun TaskModel.toEntity() = TaskEntityDto(taskId, taskName, description, time)