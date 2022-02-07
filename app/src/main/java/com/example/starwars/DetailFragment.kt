package com.example.starwars

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.starwars.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val name = requireArguments().getString(DetailFragment.BUNDLE_NAME)
            val age = requireArguments().getInt(DetailFragment.BUNDLE_AGE)
            val planet = requireArguments().getString(DetailFragment.BUNDLE_PLANET)
            val faction = requireArguments().getString(DetailFragment.BUNDLE_FACTION)

            binding.apply {
                fragmentName.text = name
                fragmentAge.text = age.toString()
                fragmentPlanet.text = planet
                fragmentFaction.text = faction
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_NAME = "name"
        const val BUNDLE_AGE = "age"
        const val BUNDLE_PLANET = "planet"
        const val BUNDLE_FACTION = "faction"

        fun newInstance(character: Character): DetailFragment {
            val bundle = bundleOf(
                BUNDLE_NAME to character.name,
                BUNDLE_AGE to character.age,
                BUNDLE_PLANET to character.planet,
                BUNDLE_FACTION to character.faction
            )

            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            return detailFragment
        }
    }
}