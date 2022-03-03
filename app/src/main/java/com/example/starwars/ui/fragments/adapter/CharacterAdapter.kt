package com.example.starwars.ui.fragments.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.CharacterListItemBinding
import com.example.starwars.databinding.HeaderItemBinding
import com.example.starwars.models.Character

class CharacterAdapter(
    private val onItemSelected: (character: Character, position: Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private val characters = mutableListOf<Character>()

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ITEM_VIEW_TYPE_HEADER
            else -> ITEM_VIEW_TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return if (viewType == ITEM_VIEW_TYPE_HEADER) {
            val binding = HeaderItemBinding.inflate(layoutInflater, parent, false)
            HeaderViewHolder(binding)
        } else {
            val binding = CharacterListItemBinding.inflate(layoutInflater, parent, false)
            CharacterViewHolder(binding) { position ->
                onItemSelected(characters[getPosition(position)], getPosition(position))
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(characters: List<Character>) {
        this.characters.clear()
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CharacterViewHolder)
            holder.bind(characters[getPosition(position)])
    }

    override fun getItemCount() = characters.size + 1

    private fun getPosition(position: Int): Int {
        return position - 1
    }

    inner class CharacterViewHolder(
        private val binding: CharacterListItemBinding,
        private val onItemClick: (adapterPos: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { onItemClick(adapterPosition) }
        }

        fun bind(character: Character) {
            this.binding.name.text = character.name
        }
    }

    inner class HeaderViewHolder(binding: HeaderItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private const val ITEM_VIEW_TYPE_HEADER = 0
        private const val ITEM_VIEW_TYPE_ITEM = 1
    }
}
