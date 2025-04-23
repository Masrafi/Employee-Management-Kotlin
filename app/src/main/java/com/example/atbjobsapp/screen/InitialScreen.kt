package com.example.atbjobsapp.screen

import androidx.compose.foundation.Image
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.atbjobsapp.service.NavigationService
import com.example.atbjobsapp.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Box
import android.graphics.Color


@Composable
fun InitialScreen(navController: NavController){
    val navigationService = NavigationService(navController)
    Column() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.initial),
                contentDescription = "Initial Image"
            )
        }
        LinearProgressIndicator(
        )

    }

}