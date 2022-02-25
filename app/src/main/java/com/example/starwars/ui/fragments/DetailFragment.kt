package com.example.starwars.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.example.starwars.databinding.FragmentDetailBinding
import com.example.starwars.ui.viewmodels.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        detailViewModel.fillData(requireArguments().getInt(BUNDLE_ID))

        detailViewModel.character.observe(viewLifecycleOwner) { newCharacter ->
            binding.apply {
                fragmentName.text = newCharacter.name
                fragmentAge.text = newCharacter.birthYear
                fragmentPlanet.text = newCharacter.homeworld
                detailProgress.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_ID = "id"

        fun newInstance(id: Int): DetailFragment {
            val bundle = bundleOf(BUNDLE_ID to id)

            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle

            return detailFragment
        }
    }
}