package com.example.hw6_7m.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw6_7m.databinding.FragmentTaskBinding
import com.example.hw6_7m.presentation.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskBinding.inflate(layoutInflater)
    }

    private val taskViewModel: TaskViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}