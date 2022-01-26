package com.example.starwars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.character_list_item, parent, false)

        return ViewHolder(view)
    }

    // Fills out each of the RecyclerView items at a position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]

        holder.name.text = character.name
        holder.planet.text = character.planet
        holder.age.text = character.age.toString()
    }

    override fun getItemCount(): Int = characters.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val planet: TextView = itemView.findViewById(R.id.planet)
        val age: TextView = itemView.findViewById(R.id.age)
    }
}