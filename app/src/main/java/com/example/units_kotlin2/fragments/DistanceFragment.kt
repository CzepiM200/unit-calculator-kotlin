package com.example.units_kotlin2.fragments

import android.os.Bundle
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

class DistanceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_distance, container, false)
        //view.inputDistance.setTextColor(32)
        view.distance_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                inputDistance.setText("Dziala")
            }
        }
        return view;
    }

}
