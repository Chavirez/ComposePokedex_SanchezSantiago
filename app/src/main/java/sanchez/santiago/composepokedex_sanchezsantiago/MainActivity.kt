package sanchez.santiago.composepokedex_sanchezsantiago


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import sanchez.santiago.composepokedex_sanchezsantiago.domain.Pokemon
import sanchez.santiago.composepokedex_sanchezsantiago.screens.PokemonDetailScreen
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.ComposePokedex_sanchezsantiagoTheme

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon(name = "Pikachu", number = 25, type = "Eléctrico",
        description = "asdgasdgasdgasdfasdfasdfasdfasdf.", height = 0.4f, weight = 6f, fav = true,
        ability = "Estática", imagen = R.drawable.pikachu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedex_sanchezsantiagoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokemonDetailScreen(
                        pokemon,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}





