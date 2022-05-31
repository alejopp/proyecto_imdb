package com.example.alejobootcampandroid.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.alejobootcampandroid.adapters.UserOptionsAdapter
import com.example.alejobootcampandroid.databinding.FragmentUserBinding
import com.example.alejobootcampandroid.providers.UserOptionsProvider

class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Filling the UserOptions RecyclerView
        val rvUserOptions = binding.rvUserOptions
        rvUserOptions.adapter = UserOptionsAdapter(UserOptionsProvider.userOptionsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}