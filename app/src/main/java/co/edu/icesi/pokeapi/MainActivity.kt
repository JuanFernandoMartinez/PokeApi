package co.edu.icesi.pokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import co.edu.icesi.pokeapi.databinding.ActivityMainBinding
import co.edu.icesi.pokeapi.model.services.RetrofitServices
import co.edu.icesi.pokeapi.viewmodel.MainViewModel
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel._pokemon.observe(this){
            binding.pokemonName.text = it.name
            binding.attackStat.text = it.stats[1].base_stat.toString()
            binding.healthStat.text = it.stats[0].base_stat.toString()
            binding.defenseStat.text = it.stats[2].base_stat.toString()
            binding.speedStat.text = it.stats[5].base_stat.toString()
            Glide.with(this@MainActivity)
                .load(it.sprites.front_default)
                .into(binding.pokemonImage)
        }
        binding.searchButton.setOnClickListener{
            viewModel.searchPokemon(
                binding.searchBox.editText?.text.toString()
            )
        }
        }





    }




