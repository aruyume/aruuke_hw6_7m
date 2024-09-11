package com.example.hw6_7m.presentation.ui.fragments.taskCreate

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.Calendar
import androidx.navigation.fragment.findNavController
import com.example.hw6_7m.databinding.FragmentTaskCreateBinding
import com.example.hw6_7m.presentation.models.TaskEntityUi
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskCreateFragment : Fragment() {

    private val binding by lazy {
        FragmentTaskCreateBinding.inflate(layoutInflater)
    }

    private val viewModel: TaskCreateViewModel by viewModel()

    private var selectedTime: Long = System.currentTimeMillis()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBtnCreateListener()
        setupTimePickerButton()
    }

    private fun setupBtnCreateListener() {
        binding.btnCreate.setOnClickListener {
            val taskName = binding.etTaskName.text.toString()
            val description = binding.etTaskDesc.text.toString()

            if (taskName.isNotEmpty() && description.isNotEmpty()) {
                viewModel.insertTask(
                    TaskEntityUi(
                        taskId = 0,
                        taskName = taskName,
                        description = description,
                        time = selectedTime
                    )
                )
                findNavController().popBackStack()
            } else {
                showErrorMessage("Пожалуйста заполните поле")
            }
        }
    }

    private fun setupTimePickerButton() {
        binding.btnSelectTime.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->
                val selectedTimeInMillis = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, selectedHour)
                    set(Calendar.MINUTE, selectedMinute)
                }.timeInMillis
                selectedTime = selectedTimeInMillis
                binding.btnSelectTime.text = formatTime(selectedTimeInMillis)
            },
            hour,
            minute,
            true
        ).show()
    }

    private fun formatTime(timeInMillis: Long): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return String.format("%02d:%02d", hour, minute)
    }
}