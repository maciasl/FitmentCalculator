package com.example.testapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.testapp.databinding.FragmentFifthBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FifthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FifthFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentFifthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun calculateFitment(view: View) {
        // Get the text view
        val showFitmentTextView = view.findViewById<TextView>(R.id.textView_fitment3)
        val showWheelWidthTextView = view.findViewById<TextView>(R.id.textView_wheel_width3)
        val showWheelOffsetTextView = view.findViewById<TextView>(R.id.textView_wheel_offset3)
        //val showTestResultsTextView = view.findViewById<TextView>(R.id.textView_fitment)
        // Get the value of the text view.
        val widthString = showWheelWidthTextView.text.toString()
        val offsetString = showWheelOffsetTextView.text.toString()
        // Convert value to a number and increment it
        var width = widthString.toFloat()
        val offset = offsetString.toFloat()
        width /= 2
        // Convert half width into millimeters
        width *= (25.4f)
        width = width-offset
        width -= 10

        // Display the new value in the text view.
        showFitmentTextView.text = width.toString()
    }

    private fun increaseWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheel_width3)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toFloat()
        count += (0.5f)
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun decreaseWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheel_width3)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toFloat()
        count -= (0.5f)
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun increaseOffset(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheel_offset3)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count += (1)
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun decreaseOffset(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheel_offset3)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count -= (1)
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


        }
    }
    private fun openUrl(view: View) {
        // Get the text view
        val showWheelWidthTextView = view.findViewById<TextView>(R.id.textView_wheel_width3)
        val showOffsetTextView = view.findViewById<TextView>(R.id.textView_fitment3)
        // Get the value of the text view.
        val wheelWidthString = showWheelWidthTextView.text.toString()
        val offsetString = showOffsetTextView.text.toString()
        // Convert value to a number and increment it
        val string1 = "https://www.fitmentindustries.com/store/wheels?sort=instock&width="
        val string2 = "&offset="
        val string3 = "&saleToggle=0&qdToggle=0&suspension=Stock&modification=No%20Modification&rubbing=No%20rubbing%20or%20scrubbing"
        val url = string1+wheelWidthString+string2+offsetString+string3
        // Display the new value in the text view.
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
    private fun openHelp(view: View) {
        val url = "https://www.drivingline.com/articles/idiots-guide-to-wheel-fitment/#:~:text=Put%20simply%2C%20to%20find%20if,to%20see%20if%20it%20fits."
        // Display the new value in the text view.
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root


        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_calculate3).setOnClickListener {
            calculateFitment(view)
        }

//        binding.buttonNext3.setOnClickListener {
//            findNavController().navigate(R.id.action_thirdFragment3_to_SecondFragment)
//        }

        view.findViewById<Button>(R.id.button_increase_width3).setOnClickListener {
            increaseWidth(view)
        }
        view.findViewById<Button>(R.id.button_width_decrease3).setOnClickListener {
            decreaseWidth(view)
        }
        view.findViewById<Button>(R.id.button_increase_offset3).setOnClickListener {
            increaseOffset(view)
        }
        view.findViewById<Button>(R.id.button_offset_decrease3).setOnClickListener {
            decreaseOffset(view)
        }
        view.findViewById<Button>(R.id.button_buy_link_poke).setOnClickListener {
            openUrl(view)
        }
        view.findViewById<Button>(R.id.button_measuring3).setOnClickListener {
            openHelp(view)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FifthFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FifthFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}