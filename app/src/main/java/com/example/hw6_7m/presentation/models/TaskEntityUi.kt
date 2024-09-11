package com.example.hw6_7m.presentation.models

import com.example.domain.model.TaskModel
import java.io.Serializable

data class TaskEntityUi(
    val taskId: Long,
    val taskName: String,
    val description: String,
    val time: Long
) : Serializable

fun TaskModel.toUi(): TaskEntityUi {
    return TaskEntityUi(
        taskId = this.taskId,
        taskName = this.taskName,
        description = this.description,
        time = this.time
    )
}

fun TaskEntityUi.fromDomain() = TaskModel(taskId, taskName, description, time)
