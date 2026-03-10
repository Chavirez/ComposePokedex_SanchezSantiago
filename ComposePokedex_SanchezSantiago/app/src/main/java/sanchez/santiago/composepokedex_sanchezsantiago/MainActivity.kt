package sanchez.santiago.composepokedex_sanchezsantiago


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import sanchez.santiago.composepokedex_sanchezsantiago.navigation.MyApp
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.ComposePokedex_sanchezsantiagoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedex_sanchezsantiagoTheme {
                MyApp()
            }
        }
    }
}
