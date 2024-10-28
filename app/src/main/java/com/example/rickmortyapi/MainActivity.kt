package com.example.rickmortyapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.rickmortyapi.data.RetrofitService
import com.example.rickmortyapi.data.RetrofitServiceFactory
import com.example.rickmortyapi.ui.theme.RickMortyApiTheme
import kotlinx.coroutines.launch

import com.example.rickmortyapi.data.model.Result as CharacterResult


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val service = RetrofitServiceFactory.makeRetrofitService()

        lifecycleScope.launch{

            val characters = service.listCharacters()
            println(characters)
//            movies.results.forEach { character ->
//                println(character.name)
//            }
        }


//        setContent {
//            RickMortyApiTheme {
//                val characters by produceState(initialValue = emptyList<Result>()) {
//                    value = service.listCharacters().results
//                }
//
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    Greeting(
////                        name = "Android",
////                        modifier = Modifier.padding(innerPadding)
////                    )
//                    CharacterList(
//                        characters = characters,
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
        setContent {
            RickMortyApiTheme {
                // Cambiamos a CharacterResult
                val characters by produceState(initialValue = emptyList<CharacterResult>()) {
                    // Usamos con el `await` dentro de la coroutine
                    value = service.listCharacters().results
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CharacterList(
                        characters = characters,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickMortyApiTheme {
        Greeting("Android")
    }
}