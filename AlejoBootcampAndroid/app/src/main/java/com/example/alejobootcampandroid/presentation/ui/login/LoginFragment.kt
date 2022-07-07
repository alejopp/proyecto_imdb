package com.example.alejobootcampandroid.presentation.ui.login

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.utils.Constants
import com.example.alejobootcampandroid.utils.Constants.ERROR
import com.example.alejobootcampandroid.utils.Constants.TITLE
import com.example.alejobootcampandroid.databinding.FragmentLoginBinding
import com.example.alejobootcampandroid.utils.UserDataValidation
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
        observers()
    }

    private fun observers() {
        loginViewModel.messages.observe(viewLifecycleOwner) {
            loginViewModel.messages.observe(viewLifecycleOwner) { messages ->
                if (messages[TITLE] == ERROR) {
                    val builder = AlertDialog.Builder(context)
                        .setTitle(messages[TITLE])
                        .setMessage(messages[Constants.MESSAGE])
                        .setPositiveButton(getString(R.string.accept), null)
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                } else {
                    findNavController().navigate(
                        R.id.navigation_user, bundleOf("email" to binding.etvUserEmail.text.toString()))
                }
            }
        }
    }

    private fun listeners(){
        binding.btLogin.setOnClickListener {
            with(binding){
                areAllFieldsFilled(etvUserEmail.text.toString(), etvPassword.text.toString())
                if(etvUserEmail.error == null && etvPassword.error == null){
                    loginViewModel.signIn(etvUserEmail.text.toString(), etvPassword.text.toString())
                }
            }
        }

        binding.tvSignup.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup, null )
        }

        binding.tvGuest.setOnClickListener {
            findNavController().navigate(R.id.navigation_home, null)
        }
    }

    private fun areAllFieldsFilled(email: String, password: String) {
        with(binding){
            etvUserEmail.error= UserDataValidation.isFieldEmpty(email)
            etvPassword.error = UserDataValidation.isFieldEmpty(password)
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}