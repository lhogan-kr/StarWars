package com.example.starwars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.CharacterListItemBinding

class CharacterAdapter(
    private val characters: List<Character>,
    private val onItemSelected: (character: Character) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private lateinit var binding: CharacterListItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = CharacterListItemBinding.inflate(layoutInflater, parent, false)

        return CharacterViewHolder(binding) { position ->
            onItemSelected(characters[position])
        }
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
            binding.name.text = character.name
            binding.age.text = character.age.toString()
        }
    }
}