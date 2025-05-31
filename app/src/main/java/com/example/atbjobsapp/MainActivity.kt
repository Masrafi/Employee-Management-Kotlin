package com.example.atbjobsapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.atbjobsapp.screen.Home
import com.example.atbjobsapp.screen.InitialScreen
import com.example.atbjobsapp.screen.LogIn
import com.example.atbjobsapp.screen.Option
import com.example.atbjobsapp.screen.SignUp
import androidx.core.view.WindowCompat
import com.example.atbjobsapp.screen.HomeStatus
import com.example.atbjobsapp.screen.InOut
import com.example.atbjobsapp.screen.LocationStatus
import com.example.atbjobsapp.screen.SetLocation
import com.example.atbjobsapp.screen.UpdateProfile

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AppNavigation()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "option") {
        composable("first_screen") { InitialScreen(navController) }
        composable("option") { Option(navController) }
        composable("signup") { SignUp(navController) }
        composable("login") { LogIn(navController) }
        composable("home_status") { HomeStatus(navController) }
        //composable("home/{text}") { Home(navController) }
        composable("inout") { InOut(navController) }
        composable("location_status") { LocationStatus(navController) }
        composable("update_profile") { UpdateProfile(navController) }
        composable("set_location") { SetLocation(navController) }
        composable("home/{text}") { backStackEntry ->
            val text = backStackEntry.arguments?.getString("text")
            Home(navController, text)
        }
    }
}