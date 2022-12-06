package com.example.testapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_thirdFragment3)
        }
        binding.buttonTireSize.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_sixthFragment)
        }
//            // find the toast_button by its ID and set a click listener
//        view.findViewById<Button>(R.id.toast_button).setOnClickListener {
//            // create a Toast with some text, to appear for a short time
//            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
//            // show the Toast
//            myToast.show()
//        }
//        view.findViewById<Button>(R.id.count_button).setOnClickListener {
//            countMe(view)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}