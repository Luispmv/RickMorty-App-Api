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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.rickmortyapi.data.model.Result as CharacterResult
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource

@Composable
fun CharacterDetailScreen(character: CharacterResult, onBackClick: () -> Unit) {
    Column(modifier = Modifier.padding(100.dp)) {
        // Encabezado personalizado
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
//                Icon(Icons.Default.ArrowBack)
                Image(
                    painter = painterResource(id = com.example.rickmortyapi.R.drawable.back), // Cambia 'back' al nombre de tu archivo sin extensión
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(24.dp) // Ajusta el tamaño según lo necesites
                        .clickable(onClick = onBackClick) // Añade la funcionalidad de clic
                )
            }


            Spacer(modifier = Modifier.width(8.dp))
            Text(text = character.name)
        }

        // Contenido principal
        Image(
            painter = rememberImagePainter(character.image),
            contentDescription = character.name,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Estado: ${character.status}")
        Text(text = "Espacie: ${character.species}")
        Text(text = "Genero: ${character.gender}")
        Text(text = "Ubicacion: ${character.location.name}")
        // Puedes agregar más detalles aquí
    }
}

