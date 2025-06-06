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
    fun navigateToHome(text: String) {
        navController.navigate("home/{text}")
    }
    fun navigateToHomeStatus() {
        navController.navigate("home_status")
    }    
    fun navigateToInOut() {
        navController.navigate("inout")
    }
    fun navigateToUpdateProfile() {
        navController.navigate("update_profile")
    }
    fun navigateToLocationStatus() {
        navController.navigate("location_status")
    }
    fun navigateToSetLocation() {
        navController.navigate("set_location")
    }
//    fun navigateToSignUp() {
//        navController.navigate("signup")
//    }
    
    

    fun goBack() {
        navController.popBackStack()
    }
}
