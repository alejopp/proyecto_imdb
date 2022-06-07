package com.example.alejobootcampandroid.ui.user.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.FragmentUserBinding
import com.example.alejobootcampandroid.providers.UserOptionsProvider
import com.example.alejobootcampandroid.ui.user.view.adapters.UserOptionsAdapter
import com.example.alejobootcampandroid.ui.user.viewmodel.UserViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        _binding = FragmentUserBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuBottomNavbar = activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.menu
        menuBottomNavbar?.findItem(R.id.navigation_user)?.setTitle(arguments?.getString("user_name"))

        binding.tvUserUsername.text = arguments?.getString("user_name")

        // Filling the UserOptions RecyclerView
        val rvUserOptions = binding.rvUserActions
        rvUserOptions.adapter = UserOptionsAdapter(UserOptionsProvider.userOptionsList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}