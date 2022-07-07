package com.example.alejobootcampandroid.presentation.ui.signup

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.utils.Constants.MESSAGE
import com.example.alejobootcampandroid.utils.Constants.SUCCESS
import com.example.alejobootcampandroid.utils.Constants.TITLE
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
            with(binding){
                areAllFieldsFilled(etvSignupName.text.toString(),etvSignupEmail.text.toString(),
                    etvSignupPassword.text.toString()
                )
                if(tilSignupName.error == null && tilSignupEmail.error == null &&
                    tilSignupPassword.error == null){
                    signUpViewModel.signUp(etvSignupName.text.toString(),etvSignupEmail.text.toString(),
                        etvSignupPassword.text.toString())
                }
            }
        }

        observers()

        //Set arrow back event
        binding.toolbarSignup.setOnMenuItemClickListener{ arrowBack ->
            onOptionsItemSelected(arrowBack).also {
                findNavController().navigate(R.id.action_to_navigation_login)
            }
        }
    }

    private fun observers(){
        signUpViewModel.messages.observe(viewLifecycleOwner){messages ->
            val builder = AlertDialog.Builder(context)
                .setTitle(messages[TITLE])
                .setMessage(messages[MESSAGE])
                .setPositiveButton(getString(R.string.accept),null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
            if (messages[TITLE] == SUCCESS){
                findNavController().navigate(R.id.navigation_home)
            }
        }
    }

    private fun areAllFieldsFilled(userName: String, email: String, password: String) {
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