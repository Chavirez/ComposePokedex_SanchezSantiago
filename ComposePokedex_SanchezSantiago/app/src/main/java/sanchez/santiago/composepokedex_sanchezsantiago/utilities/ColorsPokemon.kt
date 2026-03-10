package sanchez.santiago.composepokedex_sanchezsantiago.utilities

import androidx.compose.ui.graphics.Color
import sanchez.santiago.composepokedex_sanchezsantiago.domain.Pokemon
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.*

fun getColorByType(pokemon: Pokemon): Pair<Color, Color> {
    var color: Color
    var dark = true
    when{
        pokemon.type.lowercase().contains("normal") -> color = Normal
        pokemon.type.lowercase().contains("electric") -> {
            color = ElectricYellow
            dark = false
            return Pair(color, OffWhite)
        }
        pokemon.type.lowercase().contains("water") -> {
            color = Water
            return Pair(color, OffWhite)
        }
        pokemon.type.lowercase().contains("fire") -> color = Fire
        pokemon.type.lowercase().contains("fairy") -> {
            color = Fairy
            dark = false
            return Pair(color, OffWhite)
        }
        pokemon.type.lowercase().contains("psychic") -> {
            color = Psych
            return Pair(color, OffWhite)
        }
        pokemon.type.lowercase().contains("fighting") -> {
            color = Fight
            dark = false
            return Pair(color, OffWhite)
        }
        pokemon.type.lowercase().contains("ghost") -> color = Ghost
        pokemon.type.lowercase().contains("bug") -> color = Bug
        pokemon.type.lowercase().contains("poison") -> color = Poison
        pokemon.type.lowercase().contains("ground") -> color = Ground
        pokemon.type.lowercase().contains("rock") -> color = Rock
        pokemon.type.lowercase().contains("flying") -> {
            color = Flying
            return Pair(color, OffWhite)
        }



    }
    return TODO("Provide the return value")
}