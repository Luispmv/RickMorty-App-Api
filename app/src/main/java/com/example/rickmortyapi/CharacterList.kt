package com.example.rickmortyapi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.example.rickmortyapi.data.model.Result as CharacterResult


//@Composable
//fun CharacterList(characters: List<CharacterResult> ) {
//    LazyColumn(modifier = Modifier.fillMaxSize()) {
//        items(characters) { character ->
//            CharacterItem(character = character)
//        }
//    }
//}
@Composable
fun CharacterList(characters: List<CharacterResult>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(characters) { character ->
            CharacterItem(character = character)
        }
    }
}

