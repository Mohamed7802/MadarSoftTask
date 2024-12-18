package com.devmohamed.madarsofttask.ui.input

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.devmohamed.madarsofttask.R
import com.devmohamed.madarsofttask.data.entity.User
import com.devmohamed.madarsofttask.databinding.FragmentInputBinding
import com.devmohamed.madarsofttask.viewmodel.UserViewModel

class InputFragment : Fragment() {
    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.saveButton.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val age = binding.ageInput.text.toString()
            val jobTitle = binding.jobInput.text.toString()
            val gender = if (binding.maleRadio.isChecked) "Male" else "Female"

            if (name.isBlank() || age.isBlank() || jobTitle.isBlank()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(name = name, age = age.toInt(), jobTitle = jobTitle, gender = gender)
            viewModel.insertUser(user)
            findNavController().navigate(R.id.action_inputFragment_to_displayFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
