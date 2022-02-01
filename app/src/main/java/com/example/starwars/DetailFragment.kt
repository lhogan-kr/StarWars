package com.example.starwars

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val age = requireArguments().getInt("age")
            val planet = requireArguments().getString("planet")
            val faction = requireArguments().getString("faction")

            view.findViewById<TextView>(R.id.fragment_name).text = name
            view.findViewById<TextView>(R.id.fragment_age).text = age.toString()
            view.findViewById<TextView>(R.id.fragment_planet).text = planet
            view.findViewById<TextView>(R.id.fragment_faction).text = faction
        }

        return view
    }
}