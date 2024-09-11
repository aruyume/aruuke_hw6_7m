package com.example.hw6_7m.presentation.ui.fragments.taskList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6_7m.databinding.ItemTaskBinding
import com.example.hw6_7m.presentation.models.TaskEntityUi

class TaskAdapter : ListAdapter<TaskEntityUi, TaskAdapter.TaskViewHolder>(TaskDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(taskEntityUi: TaskEntityUi) {
            with(binding) {
                tvTaskName.text = taskEntityUi.taskName
                tvTaskDesc.text = taskEntityUi.description
                tvTaskTime.text = formatTime(taskEntityUi.time)
            }
        }

        private fun formatTime(timeInMillis: Long): String {
            val calendar = java.util.Calendar.getInstance().apply {
                setTimeInMillis(timeInMillis)
            }
            val hour = calendar.get(java.util.Calendar.HOUR_OF_DAY)
            val minute = calendar.get(java.util.Calendar.MINUTE)
            return String.format("%02d:%02d", hour, minute)
        }
    }

    companion object {
        class TaskDiffUtil : DiffUtil.ItemCallback<TaskEntityUi>() {
            override fun areItemsTheSame(oldItem: TaskEntityUi, newItem: TaskEntityUi): Boolean {
                return oldItem.taskId == newItem.taskId
            }

            override fun areContentsTheSame(oldItem: TaskEntityUi, newItem: TaskEntityUi): Boolean {
                return oldItem == newItem
            }
        }
    }
}