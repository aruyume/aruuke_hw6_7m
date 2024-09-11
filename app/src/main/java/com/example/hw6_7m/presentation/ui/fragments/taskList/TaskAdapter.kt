package com.example.hw6_7m.presentation.ui.fragments.taskList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw6_7m.databinding.ItemTaskBinding
import com.example.hw6_7m.presentation.models.TaskEntityUi

class TaskAdapter :
    ListAdapter<TaskEntityUi, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        ViewHolder(binding.root) {
        fun bind(taskEntityUi: TaskEntityUi) {
            binding.tvTaskName.text = taskEntityUi.taskName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TaskDiffCallback : DiffUtil.ItemCallback<TaskEntityUi>() {
    override fun areItemsTheSame(oldItem: TaskEntityUi, newItem: TaskEntityUi) =
        oldItem.taskId == newItem.taskId

    override fun areContentsTheSame(oldItem: TaskEntityUi, newItem: TaskEntityUi) =
        oldItem == newItem
}