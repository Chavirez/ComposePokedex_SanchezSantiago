package sanchez.santiago.composepokedex_sanchezsantiago.components

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sanchez.santiago.composepokedex_sanchezsantiago.domain.Pokemon
import sanchez.santiago.composepokedex_sanchezsantiago.dummies.getOnePokemon
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.Pink40
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.PurpleGrey40
import sanchez.santiago.composepokedex_sanchezsantiago.ui.theme.White
import sanchez.santiago.composepokedex_sanchezsantiago.utilities.getColorByType

@Composable
fun PokemonGridItem(pokemon: Pokemon, onNavigationDetail:(id:Int)-> Unit){
    val colors = getColorByType(pokemon)
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = {onNavigationDetail(pokemon.number)})
    ){
        Box{
            Image(painter = painterResource(pokemon.imagen),
                contentDescription = pokemon.name,
                Modifier.size(150.dp), contentScale = ContentScale.Fit)
            Row(Modifier.size(35.dp, 35.dp)
                .background(colors.first, shape = RoundedCornerShape(40.dp))
                .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center)
            {
                Text(text = "${pokemon.number}", color = White, textAlign = TextAlign.Center, fontSize = 8.sp)
            }
        }
        Text(text = "${pokemon.name}", textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonGridItemPreview(){
    PokemonGridItem(getOnePokemon(),{id->{}})
}