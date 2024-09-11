package com.example.hw6_7m.presentation.ui.fragments.taskDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.hw6_7m.databinding.FragmentTaskDetailsBinding
import com.example.hw6_7m.presentation.models.TaskEntityUi
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel: TaskDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBtnCreateListener()
    }

    private fun setupBtnCreateListener() {
        binding.btnCreate.setOnClickListener {
            val taskName = binding.etDesc.text.toString()
            viewModel.insertTask(TaskEntityUi(taskName = taskName))

            setFragmentResult("taskRequestKey", Bundle().apply {
                putString("newTaskName", taskName)
            })

            findNavController().popBackStack()
        }
    }
}