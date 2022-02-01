package com.example.starwars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Fill out the data set
        val characters = mutableListOf(
            Character("Luke Skywalker", 24, "Tattoine", "Rebellion"),
            Character("Darth Vader", 60, "Tattoine", "Empire")
        )

        for (i in 3..20) {
            characters.add(if (i % 2 == 0) characters[1] else characters[0])
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = CharacterAdapter(characters)

        return view
    }
}