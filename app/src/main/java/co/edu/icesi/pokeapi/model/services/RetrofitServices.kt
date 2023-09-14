package co.edu.icesi.pokeapi.model.services

import co.edu.icesi.pokeapi.model.repository.PokedexRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitServices {
    var pokedexServices =Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    var pokedexRepository = pokedexServices.create(PokedexRepository::class.java)
}