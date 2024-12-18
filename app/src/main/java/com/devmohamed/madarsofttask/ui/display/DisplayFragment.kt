package com.devmohamed.madarsofttask.ui.display

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.devmohamed.madarsofttask.databinding.FragmentDisplayBinding
import com.devmohamed.madarsofttask.viewmodel.UserViewModel

class DisplayFragment : Fragment() {
    private var _binding: FragmentDisplayBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewModel.getAllUsers { users ->
            val displayText = users.joinToString("\n") {
                "Name: ${it.name}, Age: ${it.age}, Job: ${it.jobTitle}, Gender: ${it.gender}"
            }
            binding.usersTextView.text = displayText
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
