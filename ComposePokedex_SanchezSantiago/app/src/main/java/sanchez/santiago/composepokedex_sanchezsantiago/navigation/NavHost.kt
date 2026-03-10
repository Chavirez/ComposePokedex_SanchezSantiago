package sanchez.santiago.composepokedex_sanchezsantiago.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import sanchez.santiago.composepokedex_sanchezsantiago.dummies.getOnePokemon
import sanchez.santiago.composepokedex_sanchezsantiago.dummies.getPokemon
import sanchez.santiago.composepokedex_sanchezsantiago.dummies.showAllPokemons
import sanchez.santiago.composepokedex_sanchezsantiago.screens.LoginScreen
import sanchez.santiago.composepokedex_sanchezsantiago.screens.PokedexMenuScreen
import sanchez.santiago.composepokedex_sanchezsantiago.screens.PokemonDetailScreen
import sanchez.santiago.composepokedex_sanchezsantiago.screens.RegisterScreen

@Composable
fun MyApp(){
    val navController = rememberNavController()
    // Login como startDestination
    NavHost(navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                onLoginSuccess = { navController.navigate(PokemonList) },
                onGoToRegister = { navController.navigate(Register) }
            )
        }
        composable<Register> {
            RegisterScreen(onRegisterSuccess = { navController.navigate(Login) })
        }
        composable<PokemonList> {
            PokedexMenuScreen(showAllPokemons()) { id ->
                navController.navigate(PokemonDetail(id = id))
            }
        }
        composable<PokemonDetail> { backStackEntry ->
            val routeData: PokemonDetail = backStackEntry.toRoute()
            val currentPokemon = getPokemon(routeData.id)

            // Ejemplo de lógica para obtener anterior y siguiente
            val prev = if (routeData.id > 1) getPokemon(routeData.id - 1) else null
            val next = getPokemon(routeData.id + 1) // Asumiendo que existe el siguiente

            PokemonDetailScreen(
                pokemon = currentPokemon,
                navPrevNext = Pair(prev, next),
                onNavigate = { id -> navController.navigate(PokemonDetail(id = id)) }
            )
        }
    }
}