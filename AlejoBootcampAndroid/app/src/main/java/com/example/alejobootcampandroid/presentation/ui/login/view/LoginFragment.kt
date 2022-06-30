package com.example.alejobootcampandroid.presentation.ui.login.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.FragmentLoginBinding
import com.example.alejobootcampandroid.presentation.ui.profile.viewmodel.ProfileViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private  val userViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set the Action botton event
        binding.btLogin.setOnClickListener {
            val userEmail = binding.etvUserEmail.text
            val userPassword = binding.etvPassword.text
            if(!userEmail.isNullOrEmpty() && !userPassword.isNullOrEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(userEmail.toString(),userPassword.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            findNavController().navigate(R.id.navigation_user )
                        }
                        else{
                            showErrorMessage()
                        }
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