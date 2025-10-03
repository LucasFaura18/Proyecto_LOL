package com.lucasfaura.mostrar_campeoneslol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasfaura.mostrar_campeoneslol.ui.theme.Mostrar_CampeonesLOLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mostrar_CampeonesLOLTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Column (
                        modifier = Modifier.padding(padding)
                    ){
                        ListaDinamicaCampeon();
                    }
                }
            }
        }
    }
}

data class Campeon( val imagen: Int, val titulo: String, val descripcion: String)

@Composable
fun ListaCampeon( campeon: Campeon){
    val imageModifier = Modifier.padding(horizontal= 16.dp, vertical = 8.dp).size(40.dp).clip(
        CircleShape
    )
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = imageModifier,
            painter = painterResource(campeon.imagen),
            contentDescription = "Imagen Campeon",
            contentScale = ContentScale.Crop
        )
        Column (
            modifier = Modifier.padding(vertical = 8.dp)
        ){
            Text(
                text = campeon.titulo,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = campeon.descripcion,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
@Composable
fun ListaDinamicaCampeon(){
    val listaDinamicaCampeon: List<Campeon> = listOf(
        Campeon(imagen = R.drawable.annie, titulo = "Annie", descripcion = "Hija de la Oscuridad"),
        Campeon(imagen = R.drawable.diana, titulo = "Diana", descripcion = "El Desdén de la Luna"),
        Campeon(imagen = R.drawable.fizz, titulo = "Fizz", descripcion = "El Bromista de las Mareas"),
        Campeon(imagen = R.drawable.irelia, titulo = "Irelia", descripcion = "La Bailarina de las Cuchillas"),
        Campeon(imagen = R.drawable.leona, titulo = "Leona", descripcion = "El Amanecer Radiante"),
        Campeon(imagen = R.drawable.mordekaiser, titulo = "Mordekaiser", descripcion = "La Pesadilla de Hierro"),
        Campeon(imagen = R.drawable.neeko, titulo = "Neeko", descripcion = "La Camaleona Curiosa"),
        Campeon(imagen = R.drawable.senna, titulo = "Senna", descripcion = "La Redentora"),
        Campeon(imagen = R.drawable.taric, titulo = "Taric", descripcion = "El Escudo de Valoran"),
        Campeon(imagen = R.drawable.teemo, titulo = "Teemo", descripcion = "El Explorador Veloz"),
        Campeon(imagen = R.drawable.vi, titulo = "Vi", descripcion = "Los Puños de Hierro"),
        Campeon(imagen = R.drawable.ziggs, titulo = "Ziggs", descripcion = "El Yordle Explosivo"))
    LazyColumn (){
        items(listaDinamicaCampeon){ campeon ->
            ListaCampeon(campeon)
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 8.dp),
                thickness = 1.dp,
                color = Color.Black
            )
        }
    }
}
