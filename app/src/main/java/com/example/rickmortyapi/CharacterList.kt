package com.example.rickmortyapi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.rickmortyapi.data.model.Result as CharacterResult

@Composable
fun CharacterList(characters: List<CharacterResult>, navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(top = 50.dp)) {
        items(characters) { character ->
//            CharacterItem(character = character)
            CharacterItem(character = character) {
                // Aquí defines la acción al hacer clic
                navController.navigate("character_detail/${character.id}")
            }
        }
    }
}

