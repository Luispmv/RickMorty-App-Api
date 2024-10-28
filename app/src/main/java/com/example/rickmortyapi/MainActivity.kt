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

//Implementando navegacion
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.rickmortyapi.CharacterList




//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        val service = RetrofitServiceFactory.makeRetrofitService()
//
//        lifecycleScope.launch{
//
//            val characters = service.listCharacters()
//            println(characters)
////            movies.results.forEach { character ->
////                println(character.name)
////            }
//        }
//
//
////        setContent {
////            RickMortyApiTheme {
////                // Cambiamos a CharacterResult
////                val characters by produceState(initialValue = emptyList<CharacterResult>()) {
////                    // Usamos con el `await` dentro de la coroutine
////                    value = service.listCharacters().results
////                }
////
////                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    CharacterList(
////                        characters = characters,
////                        modifier = Modifier.padding(innerPadding)
////                    )
////                }
////            }
////        }
//
//        setContent {
//            val navController = rememberNavController()
//
//            RickMortyApiTheme {
//                NavHost(navController = navController, startDestination = "character_list") {
//                    composable("character_list") {
//                        CharacterList(navController)
////                        CharacterList(characters = characters, navController = navController)
//
//                    }
//                    composable("character_detail/{characterId}") { backStackEntry ->
//                        val characterId = backStackEntry.arguments?.getString("characterId")?.toInt()
//                        val character = characters.first { it.id == characterId }
//                        CharacterDetailScreen(character = character) {
//                            navController.popBackStack() // Volver a la lista
//                        }
//                    }
//                }
//            }
//        }
//
//
//    }
//}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val service = RetrofitServiceFactory.makeRetrofitService()
            val navController = rememberNavController()

            RickMortyApiTheme {
                // Usar produceState para cargar los personajes de forma asincrónica
                val characters by produceState(initialValue = emptyList<CharacterResult>()) {
                    // Llamada a la API para obtener la lista de personajes
                    value = service.listCharacters().results
                }

                // Configurar la navegación
                NavHost(navController = navController, startDestination = "character_list") {
                    composable("character_list") {
                        // Pasar characters a CharacterList
                        CharacterList(characters = characters, navController = navController)
                    }
                    composable("character_detail/{characterId}") { backStackEntry ->
                        // Obtener el ID del personaje
                        val characterId = backStackEntry.arguments?.getString("characterId")?.toInt()
                        // Verificar que characters no esté vacío antes de acceder a él
                        val character = characters.first { it.id == characterId }
                        CharacterDetailScreen(character = character) {
                            navController.popBackStack() // Volver a la lista
                        }
                    }
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