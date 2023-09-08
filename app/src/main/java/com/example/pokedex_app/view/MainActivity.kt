package com.example.pokedex_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex_app.R
import com.example.pokedex_app.api.PokemonRepository
import com.example.pokedex_app.domain.Pokemon
import com.example.pokedex_app.domain.PokemonType

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.rvPokemons);

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


//        val pokemons = listOf(
//            charmander,
//            charmander,
//            charmander,
//            charmander,
//            charmander
//        );

        Thread(Runnable {
            loadPokemons()
        }).start();
    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons();

        // Caso tenha carregado os resultados
        pokemonsApiResult?.results?.let {

            // Transformando a lista de resultado em uma lista de Pokemon
            val pokemons: List<Pokemon?> = it.map { pokemonResult ->

                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt();

                val pokemonApiResult = PokemonRepository.getPokemon(number);

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map{ type ->
                            type.type
                        }
                    )
                }
            }

            val layoutManager = LinearLayoutManager(this);

            // Responsável por executar dentro da Thread principal
            recyclerView.post{
                recyclerView.layoutManager = layoutManager;
                recyclerView.adapter = PokemonAdapter(pokemons);
            }

        }

    }
}