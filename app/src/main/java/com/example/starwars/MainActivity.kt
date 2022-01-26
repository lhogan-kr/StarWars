package com.example.starwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val characters = arrayListOf<Character>(
            Character("Luke Skywalker", 24, "Tattoine"),
            Character("Darth Vader", 60, "Tattoine")
        );

        for (i in 3..20) {
            characters.add(if (i % 2 == 0) characters[1] else characters[0])
        }

        val adapter = CharacterAdapter(characters)

        recyclerView.adapter = adapter
    }
}