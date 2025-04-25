package com.example.atbjobsapp.service
import androidx.navigation.NavController

class NavigationService(private val navController: NavController) {

//    fun navigateToSecondScreen(text: String) {
//        navController.navigate("second_screen/$text")
//    }
    fun navigateToOption() {
        navController.navigate("option")
    }
    fun navigateToSignUp() {
        navController.navigate("signup")
    }
    fun navigateToLogin() {
        navController.navigate("login")
    }
//    fun navigateToSignUp() {
//        navController.navigate("signup")
//    }
    
    

    fun goBack() {
        navController.popBackStack()
    }
}
