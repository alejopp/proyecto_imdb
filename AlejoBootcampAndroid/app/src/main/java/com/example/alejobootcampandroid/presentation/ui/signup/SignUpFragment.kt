package com.example.alejobootcampandroid.presentation.ui.signup

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.app.Constants.MESSAGE
import com.example.alejobootcampandroid.app.Constants.TITLE
import com.example.alejobootcampandroid.databinding.FragmentSignUpBinding
import com.example.alejobootcampandroid.utils.UserDataValidation
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUp : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set the Action botton event
        binding.btSignupAction.setOnClickListener {
            validateForm(binding.etvSignupName.text.toString(),binding.etvSignupEmail.text.toString(),
                binding.etvSignupPassword.text.toString()
            )
            if(binding.tilSignupName.error == null && binding.tilSignupEmail.error == null &&
                binding.tilSignupPassword.error == null){
                signUpViewModel.signUp(binding.etvSignupName.text.toString(),binding.etvSignupEmail.text.toString(),
                    binding.etvSignupPassword.text.toString())
            }
        }

        observables()

        //Set arrow back event
        binding.toolbarSignup.setOnMenuItemClickListener{ arrowBack ->
            onOptionsItemSelected(arrowBack).also {
                findNavController().navigate(R.id.action_to_navigation_login)
            }
        }
    }

    private fun observables(){
        signUpViewModel.status.observe(viewLifecycleOwner){
            if (it){
                Log.i("pokemon","true")
            }else{
                Log.i("pokemon","false")
            }
        }

        signUpViewModel.messages.observe(viewLifecycleOwner){messages ->
            val builder = AlertDialog.Builder(context)
                .setTitle(messages[TITLE])
                .setMessage(messages[MESSAGE])
                .setPositiveButton(getString(R.string.accept),null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    private fun validateForm(userName: String, email: String, password: String) {
        with(binding){
            tilSignupName.error = UserDataValidation.isFieldEmpty(userName)
            tilSignupEmail.error = UserDataValidation.isFieldEmpty(email)
            tilSignupPassword.error = UserDataValidation.isFieldEmpty(password)
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