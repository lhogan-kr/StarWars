package com.example.starwars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starwars.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        // Fill out the data set
        val characters = mutableListOf(
            Character("Luke Skywalker", 24, "Tattoine", "Rebellion"),
            Character("Darth Vader", 60, "Tattoine", "Empire")
        )

        for (i in 3..20) {
            characters.add(if (i % 2 == 0) characters[1] else characters[0])
        }

        binding.recyclerView.adapter = CharacterAdapter(characters)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}