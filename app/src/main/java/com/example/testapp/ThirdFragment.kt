package com.example.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.testapp.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun calculateFitment(view: View) {
        // Get the text view
//        val showFitmentTextView = view.findViewById<TextView>(R.id.textView_test)
//        val showWheelWidthTextView = view.findViewById<TextView>(R.id.textview_wheel_width)
//        val showWheelOffsetTextView = view.findViewById<TextView>(R.id.textview_offset)
//        //val showTestResultsTextView = view.findViewById<TextView>(R.id.textView_fitment)
//        // Get the value of the text view.
//        val widthString = showWheelWidthTextView.text.toString()
//        val offsetString = showWheelOffsetTextView.text.toString()
//        // Convert value to a number and increment it
//        var width = widthString.toFloat()
//        val offset = offsetString.toFloat()
//        width /= 2
//        // Convert half width into millimeters
//        width *= (25.4f)
//        width = width-offset
//
//        // Display the new value in the text view.
//        showFitmentTextView.text = width.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
     //   return inflater.inflate(R.layout.fragment_third, container, false)

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonFlush.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment3_to_SecondFragment)
        }

        binding.buttonTucked.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment3_to_fourthFragment)
        }

        binding.buttonPoked.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment3_to_fifthFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}