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
import kotlinx.android.synthetic.main.fragment_volume.*
import kotlin.math.pow

class VolumeFragment : Fragment() {
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
        val view = inflater!!.inflate(R.layout.fragment_volume, container, false)
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
            "hm\u00B3" -> tempPow = 9
            "dam\u00B3" -> tempPow = 6
            "m\u00B3" -> tempPow = 3
            "dm\u00B3" -> tempPow = 0
            "cm\u00B3" -> tempPow = -3
            "mm\u00B3" -> tempPow = -6
        }

        exp = tempPow
        input = number
        spinnerValue = spinnerString

        vol_hm.text =  "%.4f".format(number.toDouble() * 10.0.pow(((tempPow - 9).toDouble()))) + " hm³"
        vol_dam.text = "%.4f".format(number.toDouble() * 10.0.pow(((tempPow - 6).toDouble()))) + " dam³"
        vol_m.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow - 3).toDouble())))) + " m³"
        vol_dm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow).toDouble())))) + " dm³"
        vol_cm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 3).toDouble())))) + " cm³"
        vol_mm.text = "%.4f".format((number.toDouble() * 10.0.pow(((tempPow + 6).toDouble())))) + " mm³"
    }
}