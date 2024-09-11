package com.example.hw6_7m.presentation.ui.fragments.taskList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hw6_7m.databinding.FragmentTaskBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6_7m.R

class TaskFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskBinding.inflate(layoutInflater)
    }

    private val viewModel: TaskViewModel by viewModel()

    private val taskListAdapter = TaskAdapter { task ->
        val action = TaskFragmentDirections.actionTaskFragmentToTaskDetailFragment(task)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        setupAddTaskButton()
        setupSwipeToDelete()
    }

    private fun setupRecyclerView() {
        binding.rvTasks.adapter = taskListAdapter
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.getTasks().collect { taskList ->
                taskListAdapter.submitList(taskList)
            }
        }
    }

    private fun setupAddTaskButton() {
        binding.btnTaskCreate.setOnClickListener {
            findNavController().navigate(R.id.action_taskFragment_to_taskCreateFragment)
        }
    }

    private fun setupSwipeToDelete() {
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val taskToDelete = taskListAdapter.currentList[position]
                viewModel.deleteTask(taskToDelete.taskId)
            }
        })
        itemTouchHelper.attachToRecyclerView(binding.rvTasks)
    }
}