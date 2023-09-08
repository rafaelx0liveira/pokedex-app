package com.example.pokedex_app.domain

/**
 * As data classes são utilizadas para representar dados de uma forma estruturada,
 * porém sem a necessidade de se definir getters, setters, toString, equals ou hashCode;
 * todo esse código repetitivo é gerado automaticamente pelo compilador.
 * **/
data class Pokemon (
    val imagemUrl: String,
    val number: Int,
    val name: String,
    val types: List<PokemonType>
)

