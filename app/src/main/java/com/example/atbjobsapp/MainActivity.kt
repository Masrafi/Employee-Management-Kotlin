package com.example.atbjobsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.atbjobsapp.screen.InitialScreen
import com.example.atbjobsapp.screen.LogIn
import com.example.atbjobsapp.screen.Option
import com.example.atbjobsapp.screen.SignUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "option") {
        composable("first_screen") { InitialScreen(navController) }
        composable("option") { Option(navController) }
        composable("signup") { SignUp(navController) }
        composable("login") { LogIn(navController) }
//        composable("second_screen/{text}") { backStackEntry ->
//            val text = backStackEntry.arguments?.getString("text")
//            Login(navController, text)
//        }
    }
}