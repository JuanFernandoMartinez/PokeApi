package co.edu.icesi.pokeapi.model.dto

data class Pokemon (
    var id: Int,
    var name: String,
    var sprites: Sprites,
    var stats : ArrayList<MacroStat>
)

data class Sprites(
    var front_default: String
)

data class MacroStat(
    var base_stat: Int,
    var effort : Int,
    var stat: Stat
)

data class Stat(
    var name : String,
    var url : String
)