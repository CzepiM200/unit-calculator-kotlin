package com.example.units_kotlin2.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.setPadding
import androidx.viewpager.widget.ViewPager
import com.example.units_kotlin2.R
import kotlinx.android.synthetic.main.fragment_distance.*
import kotlinx.android.synthetic.main.fragment_distance.view.*
import android.widget.Toast.*
import java.lang.Math.pow
import kotlin.math.pow

class DistanceFragment : Fragment() {
    var exp = 0;
    var input = 0;
    var spinnerValue = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_distance, container, false)
        view.distance_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerString: String = distance_spinner.getItemAtPosition(position).toString();
                val inputValue: String = inputDistance.text.toString()
                setNewValues(spinnerString, inputValue)
            }
        }
        view.inputDistance.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                setNewValues(spinnerValue, s.toString())
            }
        })
        return view;
    }

    fun setNewValues(spinnerString : String, inputValue : String) {
        var tempPow: Int = 0;
        var number: Int = 0;

        if (!inputValue.isBlank())
            number = inputValue.toInt()

        when (spinnerString) {
            "m" -> tempPow = 0
            "dm" -> tempPow = -1
            "cm" -> tempPow = -2
            "mm" -> tempPow = -3
            "µm" -> tempPow = -6
            "nm" -> tempPow = -9
            "pm" -> tempPow = -12
        }

        exp = tempPow
        input = number
        spinnerValue = spinnerString

        dst_m.text =  "%.4f".format(number.toDouble() * 10.0.pow((tempPow.toDouble()))) + " m"
        dst_dm.text = "%.4f".format(number.toDouble() * 10.0.pow(((tempPow + 1).toDouble()))) + " dm"
        dst_cm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 2).toDouble())))) + " cm"
        dst_mm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 3).toDouble())))) + " mm"
        dst_um.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 6).toDouble())))) + " µm"
        dst_nm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 9).toDouble())))) + " nm"
        dst_pm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 12).toDouble())))) + " pm"

    }
}
