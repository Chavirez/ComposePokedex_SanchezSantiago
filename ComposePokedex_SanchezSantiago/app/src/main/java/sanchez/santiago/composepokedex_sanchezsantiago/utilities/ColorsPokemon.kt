package sanchez.santiago.composepokedex_sanchezsantiago.utilities

import androidx.compose.ui.graphics.Color
import sanchez.santiago.composepokedex_sanchezsantiago.domain.Pokemon
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.*

fun getColorByType(pokemon: Pokemon): Pair<Color, Color> {
    val color: Color
    when {
        pokemon.type.lowercase().contains("normal") -> color = Normal
        pokemon.type.lowercase().contains("electric") -> return Pair(ElectricYellow, OffWhite)
        pokemon.type.lowercase().contains("water") -> return Pair(Water, OffWhite)
        pokemon.type.lowercase().contains("fire") -> color = Fire
        pokemon.type.lowercase().contains("fairy") -> return Pair(Fairy, OffWhite)
        pokemon.type.lowercase().contains("psychic") -> return Pair(Psych, OffWhite)
        pokemon.type.lowercase().contains("fighting") -> return Pair(Fight, OffWhite)
        pokemon.type.lowercase().contains("ghost") -> color = Ghost
        pokemon.type.lowercase().contains("bug") -> color = Bug
        pokemon.type.lowercase().contains("poison") -> color = Poison
        pokemon.type.lowercase().contains("ground") -> color = Ground
        pokemon.type.lowercase().contains("rock") -> color = Rock
        pokemon.type.lowercase().contains("flying") -> return Pair(Flying, OffWhite)
        pokemon.type.lowercase().contains("grass") -> color = Bug // Usando Bug como fallback si Grass no existe
        else -> color = Normal
    }
    return Pair(color, White)
}
