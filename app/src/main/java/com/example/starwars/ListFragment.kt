package com.example.starwars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fill out the data set
        val characters = mutableListOf(
            Character("Luke Skywalker", 24, "Tattoine", "Rebellion"),
            Character("Darth Vader", 60, "Tattoine", "Empire")
        )

        for (i in 3..20) {
            characters.add(if (i % 2 == 0) characters[1] else characters[0])
        }

        binding.recyclerView.adapter = CharacterAdapter(characters) { character ->
            val detailFragment = DetailFragment.newInstance(character)

            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}