package sanchez.santiago.composepokedex_sanchezsantiago.dummies

import sanchez.santiago.composepokedex_sanchezsantiago.R
import sanchez.santiago.composepokedex_sanchezsantiago.domain.Pokemon

val pokemonList = listOf(
    Pokemon(
        name = "Bulbasaur",
        number = 1,
        type = "Grass/Poison",
        description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.",
        height = 0.7f,
        weight = 6.9f,
        fav = false,
        ability = "Overgrow",
        imagen = R.drawable.bulbasaur
    ),
    Pokemon(
        name = "Ivysaur",
        number = 2,
        type = "Grass/Poison",
        description = "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs.",
        height = 1.0f,
        weight = 13.0f,
        fav = false,
        ability = "Overgrow",
        imagen = R.drawable.ivysaur
    ),
    Pokemon(
        name = "Venusaur",
        number = 3,
        type = "Grass/Poison",
        description = "The plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight.",
        height = 2.0f,
        weight = 100.0f,
        fav = true,
        ability = "Overgrow",
        imagen = R.drawable.venusaur
    ),
    Pokemon(
        name = "Charmander",
        number = 4,
        type = "Fire",
        description = "It has a preference for hot things. When it rains, steam is said to spout from the tip of its tail.",
        height = 0.6f,
        weight = 8.5f,
        fav = true,
        ability = "Blaze",
        imagen = R.drawable.charmander
    ),
    Pokemon(
        name = "Charmeleon",
        number = 5,
        type = "Fire",
        description = "It lashes about with its tail to knock down its foe. It then tears up the fallen opponent with sharp claws.",
        height = 1.1f,
        weight = 19.0f,
        fav = false,
        ability = "Blaze",
        imagen = R.drawable.charmeleon
    ),
    Pokemon(
        name = "Charizard",
        number = 6,
        type = "Fire/Flying",
        description = "It spits fire that is hot enough to melt boulders. It may cause forest fires by blowing flames.",
        height = 1.7f,
        weight = 90.5f,
        fav = true,
        ability = "Blaze",
        imagen = R.drawable.charizard
    ),
    Pokemon(
        name = "Squirtle",
        number = 7,
        type = "Water",
        description = "When it retracts its long neck into its shell, it squirts out water with vigorous force.",
        height = 0.5f,
        weight = 9.0f,
        fav = false,
        ability = "Torrent",
        imagen = R.drawable.squirtle
    ),
    Pokemon(
        name = "Wartortle",
        number = 8,
        type = "Water",
        description = "It is said to live 10,000 years. Its furry tail is popular as a symbol of longevity.",
        height = 1.0f,
        weight = 22.5f,
        fav = false,
        ability = "Torrent",
        imagen = R.drawable.wartortle
    ),
    Pokemon(
        name = "Blastoise",
        number = 9,
        type = "Water",
        description = "It crushes its foe under its heavy body to cause fainting. In a pinch, it will withdraw inside its shell.",
        height = 1.6f,
        weight = 85.5f,
        fav = true,
        ability = "Torrent",
        imagen = R.drawable.blastoise
    ),
    Pokemon(
        name = "Pikachu",
        number = 25,
        type = "Electric",
        description = "When Pikachu meet, they’ll touch their tails together and exchange electricity through them as a form of greeting.",
        height = 0.4f,
        weight = 6.0f,
        fav = true,
        ability = "Static",
        imagen = R.drawable.pikachu
    )
)

fun showAllPokemons(): List<Pokemon>{
    return pokemonList
}

fun getOnePokemon(): Pokemon {
    return pokemonList.get((0..9).random())
}

fun getPokemon(id:Int):Pokemon{
    return pokemonList.filter { pokemon ->  pokemon.number == id }.get(0)
}