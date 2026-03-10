package sanchez.santiago.composepokedex_sanchezsantiago.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import sanchez.santiago.composepokedex_sanchezsantiago.dummies.getOnePokemon
import sanchez.santiago.composepokedex_sanchezsantiago.dummies.getPokemon
import sanchez.santiago.composepokedex_sanchezsantiago.dummies.showAllPokemons
import sanchez.santiago.composepokedex_sanchezsantiago.screens.PokedexMenuScreen
import sanchez.santiago.composepokedex_sanchezsantiago.screens.PokemonDetailScreen

@Composable
fun MyApp(){

    val navController = rememberNavController()
    NavHost(navController, startDestination = PokemonList){
        composable<PokemonList>{ PokedexMenuScreen(showAllPokemons(),
            {id-> navController.navigate(route = PokemonDetail(id = id))}) }
        composable<PokemonDetail>{ backStackEntry ->
            val pokemon: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailScreen(getPokemon(pokemon.id))
        }
    }

}