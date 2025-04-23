package com.example.atbjobsapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.atbjobsapp.service.NavigationService
import com.example.design.service.ColorService
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.atbjobsapp.R

@Composable
fun Option(navController: NavController){
    val navigationService = NavigationService(navController)
    Box() {
        
            Image(
                painter = painterResource(id = R.drawable.initial),
                contentDescription = "Initial Image"
            )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { navigationService.navigateToOption() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 16.dp, bottom = 16.dp, end = 16.dp),
                //.align(Alignment.BottomCenter), // Adds space above the button
                colors = ButtonDefaults.buttonColors(containerColor = ColorService.primaryColor),
                shape = RoundedCornerShape(10.dp), // Border radius for the button
                //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue) // Button background color
            ) {
                Text(text = "Sign In", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) // Button text
            }

            Button(
                onClick = { navigationService.navigateToSignUp() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, bottom = 20.dp, end = 16.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xff000000).copy(alpha = 0.2f),
                        shape = RoundedCornerShape(10.dp)
                    ),
                //.align(Alignment.BottomCenter), // Adds space above the button
                colors = ButtonDefaults.buttonColors(containerColor = ColorService.whiteColor),
                //shape = RoundedCornerShape(10.dp), // Border radius for the button
                //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue) // Button background color
            ) {
                Text(text = "Sign Up", color = ColorService.primaryColor, fontSize = 18.sp, modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) // Button text
            }

            Text(text = "Forgot Password?" , fontSize = 15.sp, color = Color(0xff414042), modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        }   
    }

}