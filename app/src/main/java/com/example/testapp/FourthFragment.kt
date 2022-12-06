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
import com.example.testapp.databinding.FragmentFourthBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [FourthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FourthFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentFourthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun calculateFitment(view: View) {
        // Get the text view
        val showFitmentTextView = view.findViewById<TextView>(R.id.textView_Fitment2)
        val showWheelWidthTextView = view.findViewById<TextView>(R.id.textView_wheel_width2)
        val showWheelOffsetTextView = view.findViewById<TextView>(R.id.textView_wheel_offset2)
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
        width += 10

        // Display the new value in the text view.
        showFitmentTextView.text = width.toString()
    }

    private fun increaseWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheel_width2)
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
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheel_width2)
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
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheel_offset2)
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
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheel_offset2)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count -= (1)
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }
    private fun openUrl(view: View) {
        // Get the text view
        val showWheelWidthTextView = view.findViewById<TextView>(R.id.textView_wheel_width2)
        val showOffsetTextView = view.findViewById<TextView>(R.id.textView_Fitment2)
        // Get the value of the text view.
        val WheelWidthString = showWheelWidthTextView.text.toString()
        val OffsetString = showOffsetTextView.text.toString()
        // Convert value to a number and increment it
        val string1 = "https://www.fitmentindustries.com/store/wheels?sort=instock&width="
        val string2 = "&offset="
        val string3 = "&saleToggle=0&qdToggle=0&suspension=Stock&modification=No%20Modification&rubbing=No%20rubbing%20or%20scrubbing"
        val url = string1+WheelWidthString+string2+OffsetString+string3
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root


        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonCalculate2).setOnClickListener {
            calculateFitment(view)
        }
//        binding.buttonNext2.setOnClickListener {
//            findNavController().navigate(R.id.action_thirdFragment3_to_SecondFragment)
//        }

        view.findViewById<Button>(R.id.button_increase_width2).setOnClickListener {
            increaseWidth(view)
        }
        view.findViewById<Button>(R.id.button_decrease_width2).setOnClickListener {
            decreaseWidth(view)
        }
        view.findViewById<Button>(R.id.button_increase_offset2).setOnClickListener {
            increaseOffset(view)
        }
        view.findViewById<Button>(R.id.button_decrease_offset2).setOnClickListener {
            decreaseOffset(view)
        }
        view.findViewById<Button>(R.id.button_buy_link_tucked).setOnClickListener {
            openUrl(view)
        }
        view.findViewById<Button>(R.id.button_measure2).setOnClickListener {
            openHelp(view)
        }
    }

}