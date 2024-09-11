package com.example.hw6_7m.presentation.ui.fragments.taskDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.hw6_7m.databinding.FragmentTaskDetailBinding
import com.example.hw6_7m.presentation.models.TaskEntityUi
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskDetailFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskDetailBinding.inflate(layoutInflater)
    }

    private val viewModel: TaskDetailViewModel by viewModel()

    private val args: TaskDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayTaskDetails(args.task)
    }

    private fun displayTaskDetails(task: TaskEntityUi) {
        with(binding) {
            tvTaskName.text = task.taskName
            tvTaskDesc.text = task.description
            tvTaskTime.text = formatTime(task.time)
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