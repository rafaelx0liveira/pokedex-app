package com.example.pokedex_app.api.model

import com.example.pokedex_app.domain.PokemonType

data class PokemonsApiResult (
    val count: Int,
    // nullable
    val previous: String?,
    // nullable
    val next: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
)

data class PokemonTypeSlot (
    val slot: Int,
    val type: PokemonType
)

