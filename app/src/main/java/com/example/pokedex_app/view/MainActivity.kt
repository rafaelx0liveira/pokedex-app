package com.example.pokedex_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex_app.R
import com.example.pokedex_app.domain.Pokemon
import com.example.pokedex_app.domain.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemons);

        /**
         * Código refatorado com CTRL + ALT + V

        val pokemons = listOf(
        Pokemon("https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
        1,
        "Charmander",
        listOf(
        PokemonType("Fire")
        ))
        );
         * **/

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            4,
            "Charmander",
            listOf(
                PokemonType("Fire")
            )
        )

        val pokemons = listOf(
            charmander,
            charmander,
            charmander,
            charmander,
            charmander
        );

        val layoutManager = LinearLayoutManager(this);

        recyclerView.layoutManager = layoutManager;

        recyclerView.adapter = PokemonAdapter(pokemons);
    }
}