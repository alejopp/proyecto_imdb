package com.example.alejobootcampandroid.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.FragmentProfileBinding
import com.example.alejobootcampandroid.presentation.ui.profile.adapters.ProfileOptionsAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.
    private val profileViewModel : ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inflate layout
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Setting username in bottom navbar
        val menuBottomNavbar = activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.menu

        //Setting username in top profile screen
        profileViewModel.getUsername()
        profileViewModel.userName.observe(viewLifecycleOwner) { username ->
            binding.tvUserUsername.text = username
            menuBottomNavbar?.findItem(R.id.navigation_user)?.title = username
        }

        // Setting profile options recyclerview
        profileViewModel.getProfileOptions()
        profileViewModel.profileOptions.observe(viewLifecycleOwner) { profileOptions ->
            binding.rvProfileActions.also {
                it.adapter = ProfileOptionsAdapter(profileOptions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}