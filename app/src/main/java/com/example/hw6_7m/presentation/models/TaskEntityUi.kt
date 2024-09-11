package com.example.hw6_7m.presentation.models

import com.example.domain.model.TaskModel

data class TaskEntityUi(
    val taskId: Int = 0,
    val taskName: String
)

fun TaskModel.toUi() = TaskEntityUi(taskId, taskName)
fun TaskEntityUi.fromDomain() = TaskModel(taskId, taskName)