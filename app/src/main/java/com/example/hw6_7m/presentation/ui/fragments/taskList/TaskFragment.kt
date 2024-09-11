package com.example.hw6_7m.presentation.ui.fragments.taskList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hw6_7m.R
import com.example.hw6_7m.databinding.FragmentTaskBinding
import com.example.hw6_7m.presentation.models.TaskEntityUi
import com.example.hw6_7m.presentation.models.toUi
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskBinding.inflate(layoutInflater)
    }

    private val viewModel: TaskViewModel by viewModel()

    private val adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTasks.adapter = adapter
        setupFabListener()
        initFetchTasks()

        setFragmentResultListener("taskRequestKey") { _, bundle ->
            val newTaskName = bundle.getString("newTaskName")
            newTaskName?.let {
                addTaskToAdapter(it)
            }
        }
    }

    private fun initFetchTasks() {
        viewLifecycleOwner.lifecycleScope.launch {
            val tasks = viewModel.fetchTasks()
            adapter.submitList(tasks.map { it.toUi() })
        }
    }


    private fun setupFabListener() {
        binding.btnTaskCreate.setOnClickListener {
            findNavController().navigate(R.id.action_taskFragment_to_taskDetailsFragment)
        }
    }

    private fun addTaskToAdapter(taskName: String) {
        val newTask = TaskEntityUi(taskId = generateTaskId(), taskName = taskName)

        val updatedList = adapter.currentList.toMutableList()
        updatedList.add(newTask)
        adapter.submitList(updatedList)
    }

    private fun generateTaskId(): Int {
        return (adapter.currentList.maxOfOrNull { it.taskId } ?: 0) + 1
    }
}