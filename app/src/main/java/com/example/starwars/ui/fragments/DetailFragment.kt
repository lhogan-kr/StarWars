package com.example.starwars.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.example.starwars.databinding.FragmentDetailBinding
import com.example.starwars.models.Character
import com.example.starwars.ui.viewmodels.DetailViewModel

class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        detailViewModel.foo.observe(viewLifecycleOwner) { newCharacter ->
//            // Set the stuff
//            binding.fragmentAge.text = newFoo.toString()
//        }

        if (arguments != null) {
            val name = requireArguments().getString(BUNDLE_NAME)
            val age = requireArguments().getInt(BUNDLE_AGE)
            val planet = requireArguments().getString(BUNDLE_PLANET)
            val faction = requireArguments().getString(BUNDLE_FACTION)

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
                BUNDLE_AGE to character.birthYear,
                BUNDLE_PLANET to character.homeworld,
                BUNDLE_FACTION to character.eyeColor
            )

            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            return detailFragment
        }
    }
}