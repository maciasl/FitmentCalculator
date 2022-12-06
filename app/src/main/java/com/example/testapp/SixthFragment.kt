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
import java.util.logging.Logger.global
import kotlin.math.roundToInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SixthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SixthFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private fun calculateTire(view: View) {
        // Get the text view
        val showWidthTextView = view.findViewById<TextView>(R.id.textView_tire_width)
        val showAspectRatioTextView = view.findViewById<TextView>(R.id.textView_aspect_ratio)
        val showWheelDiameterTextView = view.findViewById<TextView>(R.id.textView_wheeldiameter)
        val showNewRimTextView = view.findViewById<TextView>(R.id.textView_new_rim_diameter)
        val showTireSizeTextView = view.findViewById<TextView>(R.id.textView_calculated_tire)
        val showNewRimWidthTextView = view.findViewById<TextView>(R.id.textView_new_rim_width)
        val showRimWidthTextView = view.findViewById<TextView>(R.id.textView_rim_width)
        val showFinalAspectRatioTextView = view.findViewById<TextView>(R.id.textView_final_aspectratio)
        val showFinalRimDiameterTextView = view.findViewById<TextView>(R.id.textView_final_wheeldiameter)

        // Get the value of the text view.
        val widthString = showWidthTextView.text.toString()
        val arString = showAspectRatioTextView.text.toString()
        val diameterString = showWheelDiameterTextView.text.toString()
        val newRimString = showNewRimTextView.text.toString()
        val tireCalculateString = showTireSizeTextView.text.toString()
        val newRimWidthString = showNewRimWidthTextView.text.toString()
        val rimWidthString = showRimWidthTextView.text.toString()
        // Convert value to a number and increment it
        var rimWidth = rimWidthString.toFloat()
        val width = widthString.toFloat()
        var aspectRatio = arString.toFloat()
        val diameter = diameterString.toFloat()
        val newRim = newRimString.toFloat()
        var tireSize = tireCalculateString.toFloat()
        var newWidth = newRimWidthString.toFloat()
        var roundDown = 0
        aspectRatio /= 100
        var calculate = width*aspectRatio
        calculate *= 2
        calculate += diameter
        calculate -= newRim
        val intNewRim = newRim.toInt()
        calculate /= 2
        newWidth -= rimWidth
        newWidth *= (25.4f)
        var newIntWidth = newWidth.toInt()
        rimWidth *= (25.4f)
        val newIntRimWidth = rimWidth.toInt()
        newIntWidth += newIntRimWidth
        calculate /= newIntWidth
        roundDown = newIntWidth % 10
        newIntWidth -= roundDown
        calculate *= 100
        var intCalculate = calculate.toInt()
        roundDown = intCalculate % 5
        intCalculate -= roundDown
        if (newIntWidth%10 == 0)
            newIntWidth -= 5

        // Display the new value in the text view.
        showTireSizeTextView.text = newIntWidth.toString()
        showFinalAspectRatioTextView.text = intCalculate.toString()
        showFinalRimDiameterTextView.text = intNewRim.toString()
    }

    private fun increaseWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_tire_width)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count += 10
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun decreaseWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_tire_width)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count -= 10
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun increaseAspectRatio(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_aspect_ratio)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count += 5
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun decreaseAspectRatio(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_aspect_ratio)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count -= 5
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun increaseWheelDiameter(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheeldiameter)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count += 1
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun decreaseWheelDiameter(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_wheeldiameter)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count -= 1
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun increaseWheelWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_rim_width)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toFloat()
        count += 0.5f
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun decreaseWheelWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_rim_width)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toFloat()
        count -= 0.5f
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun increaseNewRimDiameter(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_new_rim_diameter)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count += 1
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun decreaseNewRimDiameter(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_new_rim_diameter)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count -= 1
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun increaseNewRimWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_new_rim_width)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toFloat()
        count += 0.5f
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    private fun decreaseNewRimWidth(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textView_new_rim_width)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toFloat()
        count -= 0.5f
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }
    private fun openUrl(view: View) {
        // Get the text view
        val showTireWidthTextView = view.findViewById<TextView>(R.id.textView_calculated_tire)
        val showAspectRatioTextView = view.findViewById<TextView>(R.id.textView_final_aspectratio)
        val showWheelDiameterTextView = view.findViewById<TextView>(R.id.textView_final_wheeldiameter)
        // Get the value of the text view.
        val tireWidthString = showTireWidthTextView.text.toString()
        val AspectRatioString = showAspectRatioTextView.text.toString()
        val WheelDiameterString = showWheelDiameterTextView.text.toString()
        // Convert value to a number and increment it
        val string1 = "https://www.fitmentindustries.com/store/tires?&width_from="
        val string2 = "&ratio_from="
        val string3 = "&diameter_from="
        val url = string1+tireWidthString+string2+AspectRatioString+string3+WheelDiameterString
        // Display the new value in the text view.
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
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
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sixth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_final_tire_calculate).setOnClickListener {
            calculateTire(view)
        }
        view.findViewById<Button>(R.id.button_increase_tirewidth).setOnClickListener {
            increaseWidth(view)
        }
        view.findViewById<Button>(R.id.button_decrease_tirewidth).setOnClickListener {
            decreaseWidth(view)
        }
        view.findViewById<Button>(R.id.button_increase_ar).setOnClickListener {
            increaseAspectRatio(view)
        }
        view.findViewById<Button>(R.id.button_decrease_ar).setOnClickListener {
            decreaseAspectRatio(view)
        }
        view.findViewById<Button>(R.id.button_increase_wheeldiameter).setOnClickListener {
            increaseWheelDiameter(view)
        }
        view.findViewById<Button>(R.id.button_decrease_wheeldiameter).setOnClickListener {
            decreaseWheelDiameter(view)
        }
        view.findViewById<Button>(R.id.button_increase_rim_width).setOnClickListener {
            increaseWheelWidth(view)
        }
        view.findViewById<Button>(R.id.button_decrease_rim_width).setOnClickListener {
            decreaseWheelWidth(view)
        }
        view.findViewById<Button>(R.id.button_increase_new_rim).setOnClickListener {
            increaseNewRimDiameter(view)
        }
        view.findViewById<Button>(R.id.button_decrease_new_rim).setOnClickListener {
            decreaseNewRimDiameter(view)
        }
        view.findViewById<Button>(R.id.button_new_rim_width_increase).setOnClickListener {
            increaseNewRimWidth(view)
        }
        view.findViewById<Button>(R.id.button_new_rim_width_decrease).setOnClickListener {
            decreaseNewRimWidth(view)
        }
        view.findViewById<Button>(R.id.button_buy_link).setOnClickListener {
            openUrl(view)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SixthFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SixthFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}