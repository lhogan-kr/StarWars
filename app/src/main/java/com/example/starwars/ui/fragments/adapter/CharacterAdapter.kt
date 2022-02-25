package com.example.starwars.ui.fragments.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.CharacterListItemBinding
import com.example.starwars.models.Character

class CharacterAdapter(
    private val onItemSelected: (character: Character, position: Int) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private val characters = mutableListOf<Character>()
    private lateinit var binding: CharacterListItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = CharacterListItemBinding.inflate(layoutInflater, parent, false)

        return CharacterViewHolder(binding) { position ->
            onItemSelected(characters[position], position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(characters: List<Character>) {
        this.characters.clear()
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        holder.bind(characters[position])

    override fun getItemCount() = characters.size

    inner class CharacterViewHolder(
        binding: CharacterListItemBinding,
        private val onItemClick: (adapterPos: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { onItemClick(adapterPosition) }
        }

        fun bind(character: Character) {
            setIsRecyclable(true)
            binding.name.text = character.name
            binding.age.text = character.birthYear
        }
    }
}