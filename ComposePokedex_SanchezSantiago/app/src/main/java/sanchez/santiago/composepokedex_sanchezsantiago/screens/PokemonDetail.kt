package sanchez.santiago.composepokedex_sanchezsantiago.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import sanchez.santiago.composepokedex_sanchezsantiago.components.PokemonHeader
import sanchez.santiago.composepokedex_sanchezsantiago.R
import sanchez.santiago.composepokedex_sanchezsantiago.components.Ability
import sanchez.santiago.composepokedex_sanchezsantiago.components.Chip
import sanchez.santiago.composepokedex_sanchezsantiago.domain.Pokemon
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.ComposePokedex_sanchezsantiagoTheme
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.ElectricYellow
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.White

@Composable
fun PokemonCard(name: String, weight: Float, height: Float, description: String, ability: String, type: String, image: Int){
    Box(contentAlignment = Alignment.TopCenter){
        Image(painter = painterResource(image), contentDescription = name,
            Modifier.offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp)
            ,contentScale = ContentScale.Fit)
        Card(Modifier.fillMaxWidth()
            .fillMaxHeight()
            , elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            , colors = CardDefaults.cardColors( containerColor = White)){
            Column(Modifier.fillMaxWidth()) {
                Chip(type, ElectricYellow,
                    Modifier.padding(top = 70.dp)
                        .align(Alignment.CenterHorizontally))

                Row(modifier = Modifier.fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Column{
                        Ability("row", label = "Altura", "${height} m")
                        Ability("row", label = "Peso", "${weight} kg")
                    }
                    Ability("column", label = "Habilidad", ability)
                }
                Row(Modifier.fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally)
                    .padding(25.dp)) {
                    Text(description)
                }
            }

        }
    }
}

@Composable
fun PokemonDetailScreen(
    pokemon: Pokemon,
    navPrevNext: Pair<Pokemon?, Pokemon?>, // Tupla de anterior y siguiente
    onNavigate: (Int) -> Unit, // Acción de navegación
    modifier: Modifier = Modifier
) {
    val (prev, next) = navPrevNext

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(ElectricYellow, RectangleShape)
    ) {
        item {
            PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)

            // Sección de Navegación Anterior/Siguiente
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                prev?.let {
                    Text("< ${it.name}", Modifier.clickable { onNavigate(it.number) })
                }
                next?.let {
                    Text("${it.name} >", Modifier.clickable { onNavigate(it.number) })
                }
            }

            PokemonCard(
                pokemon.name, pokemon.weight, pokemon.height,
                pokemon.description, pokemon.ability, pokemon.type, pokemon.imagen
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text("Evoluciones", Modifier.padding(16.dp))
        }

        // LazyColumn para evoluciones (dentro de la misma LazyColumn principal usando items)
        items(pokemon.evolutions) { evolution ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { onNavigate(evolution.number) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(evolution.imagen),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
                Text(text = evolution.name, modifier = Modifier.padding(start = 16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailScreenPreview() {
    ComposePokedex_sanchezsantiagoTheme {
        PokemonDetailScreen(
            pokemon = Pokemon(
                name = "Pikachu",
                number = 25,
                type = "Eléctrico",
                description = "Pikachu que almacena energía eléctrica en sus mejillas para liberarla en combate.",
                height = 0.4f,
                weight = 6f,
                fav = true,
                ability = "Estática",
                imagen = R.drawable.pikachu,
                evolutions = emptyList()
            ),
            navPrevNext = Pair(null, null),
            onNavigate = {},
            modifier = Modifier
        )
    }
}
