package com.example.alejobootcampandroid.presentation.ui.signup.view

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.FragmentSignUpBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUp : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set the Action botton event
        binding.btSignupAction.setOnClickListener {
            val userName = binding.etvSignupName.text.toString()
            val bundle = bundleOf("user_name" to userName )
            val userEmail = binding.etvSignupEmail.text
            val userPassword = binding.etvSignupPassword.text
            if(!userEmail.isNullOrEmpty() && !userPassword.isNullOrEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(userEmail.toString(),userPassword.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            showSuccessMessage()
                            findNavController().navigate(R.id.navigation_user, bundle )
                        }
                        else{
                            showErrorMessage()
                        }
                    }
            }
        }

        //Set arrow back event
        binding.toolbarSignup.setOnMenuItemClickListener{ arrowBack ->
            onOptionsItemSelected(arrowBack).also {
                findNavController().navigate(R.id.action_to_navigation_login)
                //Navigation.createNavigateOnClickListener(R.id.action_to_navigation_login)
            }
        }
    }

    private fun showSuccessMessage() {
        val builder = AlertDialog.Builder(context)
            .setTitle("Success")
            .setMessage("User created successfully")
            .setPositiveButton(getString(R.string.accept),null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showErrorMessage() {
        val builder = AlertDialog.Builder(context)
            .setTitle(getString(R.string.error))
            .setMessage(getString(R.string.login_error))
            .setPositiveButton(getString(R.string.accept),null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
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