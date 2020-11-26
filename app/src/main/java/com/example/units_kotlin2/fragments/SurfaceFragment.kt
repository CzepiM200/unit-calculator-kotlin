package com.example.units_kotlin2.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.units_kotlin2.R
import kotlinx.android.synthetic.main.fragment_distance.*
import kotlinx.android.synthetic.main.fragment_distance.distance_spinner
import kotlinx.android.synthetic.main.fragment_distance.inputDistance
import kotlinx.android.synthetic.main.fragment_distance.view.*
import kotlinx.android.synthetic.main.fragment_surface.*
import kotlin.math.pow

class SurfaceFragment : Fragment() {
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
        val view = inflater!!.inflate(R.layout.fragment_surface, container, false)
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
            "km\u00B2" -> tempPow = 6
            "ha" -> tempPow = 4
            "a" -> tempPow = 2
            "m\u00B2" -> tempPow = 0
            "dm\u00B2" -> tempPow = -2
            "cm\u00B2" -> tempPow = -4
        }

        exp = tempPow
        input = number
        spinnerValue = spinnerString

        sur_km.text =  "%.4f".format(number.toDouble() * 10.0.pow(((tempPow - 6).toDouble()))) + " km\u00B2"
        sur_ha.text = "%.4f".format(number.toDouble() * 10.0.pow(((tempPow - 4).toDouble()))) + " ha"
        sur_a.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow - 2).toDouble())))) + " a"
        sur_m.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow).toDouble())))) + " m\u00B2"
        sur_dm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 2).toDouble())))) + " dm\u00B2"
        sur_cm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 4).toDouble())))) + " cm\u00B2"

    }
}