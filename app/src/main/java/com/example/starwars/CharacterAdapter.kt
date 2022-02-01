package com.example.starwars

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(
    private val characters: List<Character>
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.character_list_item, parent, false)


        return CharacterViewHolder(view) { position ->
            val activity = view.context as AppCompatActivity

            val character = characters[position]

            val bundle = bundleOf(
                "name" to character.name,
                "age" to character.age,
                "planet" to character.planet,
                "faction" to character.faction
            )

            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        holder.bind(characters[position])

    override fun getItemCount() = characters.size

    inner class CharacterViewHolder(
        itemView: View,
        private val onItemClick: (adapterPos: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val age: TextView = itemView.findViewById(R.id.age)

        init {
            itemView.setOnClickListener { onItemClick(adapterPosition) }
        }

        fun bind(character: Character) {
            name.text = character.name
            age.text = character.age.toString()
        }
    }
}