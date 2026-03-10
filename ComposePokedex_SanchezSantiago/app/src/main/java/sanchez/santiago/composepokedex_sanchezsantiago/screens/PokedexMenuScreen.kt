package sanchez.santiago.composepokedex_sanchezsantiago.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sanchez.santiago.composepokedex_sanchezsantiago.components.PokemonGridItem
import sanchez.santiago.composepokedex_sanchezsantiago.domain.Pokemon
import sanchez.santiago.composepokedex_sanchezsantiago.dummies.showAllPokemons
import sanchez.santiago.composepokedex_sanchezsantiago.navigation.PokemonDetail

@Composable
fun PokedexMenuScreen(pokemonList: List<Pokemon>, onNavigationDetail:(id:Int)-> Unit){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(5.dp, 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(pokemonList){
            pokemon ->
            PokemonGridItem(pokemon, onNavigationDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexMenuScreenPreview(){
    PokedexMenuScreen(showAllPokemons(), {id->{}})
}