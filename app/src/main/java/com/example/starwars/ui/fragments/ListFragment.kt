package com.example.starwars.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.starwars.R
import com.example.starwars.databinding.FragmentListBinding
import com.example.starwars.ui.fragments.adapter.CharacterAdapter
import com.example.starwars.ui.viewmodels.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val listViewModel: ListViewModel by viewModels()

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = CharacterAdapter(listViewModel.characters) { character ->
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