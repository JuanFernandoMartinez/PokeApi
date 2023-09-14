package co.edu.icesi.pokeapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import co.edu.icesi.pokeapi.model.dto.Pokemon
import co.edu.icesi.pokeapi.model.services.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    val _pokemon = MutableLiveData<Pokemon>()

    fun searchPokemon(searchTerm:String){
        viewModelScope.launch(Dispatchers.IO){
            val call = RetrofitServices.pokedexRepository.getPokemon(searchTerm)

            val response = call.execute()
            val pokemon = response.body()
            pokemon?.let {
                withContext(Dispatchers.Main){
                    _pokemon.value = it
                }
            }
        }

    }
}