package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.TaskModel

@Entity(tableName = "task_table")
data class TaskEntityDto(
    @PrimaryKey(autoGenerate = true) val taskId: Int = 0,
    val taskName: String
)

fun TaskEntityDto.toDomain() = TaskModel(taskId, taskName)
fun TaskModel.fromDomain() = TaskEntityDto(taskId, taskName)