package com.example.rickmortyapi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.w3c.dom.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.R
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.rickmortyapi.data.model.Result as CharacterResult
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun CharacterDetailScreen(character: CharacterResult, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Asegura que el Column ocupe el ancho completo
            .padding(horizontal = 0.dp) // Agrega padding horizontal si deseas un margen en los lados
    ) {
        // Encabezado personalizado
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(0.dp))
        }

        // Contenido principal
        Image(
            painter = rememberImagePainter(character.image),
            contentDescription = character.name,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop // La imagen se recorta para llenar el contenedor
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Texto de detalles
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = character.name, fontSize = 40.sp)
            Text(text = "Estado: ${character.status}")
            Text(text = "Especie: ${character.species}")
            Text(text = "Género: ${character.gender}")
            Text(text = "Ubicación: ${character.location.name}")
        }

        Button(shape = RectangleShape,onClick = onBackClick, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(200.dp).padding(top = 50.dp)
            .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF97CE4C), // Color de fondo del botón
                contentColor = Color.White // Color del texto
            )) {
            Text(text = "Regresar a inicio")
        }
    }
}
