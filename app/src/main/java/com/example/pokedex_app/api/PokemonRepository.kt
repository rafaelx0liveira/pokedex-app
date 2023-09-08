package com.example.pokedex_app.api

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex_app.api.model.PokemonApiResult
import com.example.pokedex_app.api.model.PokemonsApiResult
import com.example.pokedex_app.domain.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * No Kotlin, object é uma classe expecial que só é instanciada apenas uma vez, igual ao Singleton.
 * **/
object PokemonRepository{
    val baseUrl = "https://pokeapi.co/api/v2/";
    private val service: PokemonService;
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        service = retrofit.create(PokemonService::class.java);
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listPokemons(limit);

        return call.execute().body()

    }

    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemon(number);

        return call.execute().body()

    }
}