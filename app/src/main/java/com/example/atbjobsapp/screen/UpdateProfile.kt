package com.example.atbjobsapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.fillMaxSize
import com.example.atbjobsapp.R
//import androidx.compose.foundation.layout.Arrangement
//import android.text.Layout.Alignment
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.sp
import com.example.atbjobsapp.service.NavigationService
import com.example.design.service.ColorService

@Composable
fun UpdateProfile(navController: NavController){
    val navigationService = NavigationService(navController)
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 16.dp, end = 16.dp),
        //verticalArrangement = Arrangement.Center, // centers content vertically
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(id = R.drawable.edit_profile), contentDescription = "Edit Profile")
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = { Text("Designation") }, // Hint text

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Color(0xff000000).copy(0.1f),
                unfocusedTextColor = Color(0xff000000).copy(0.1f),
                focusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                unfocusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                focusedIndicatorColor = Color(0xff000000).copy(0.1f),
                unfocusedIndicatorColor = Color(0xff000000).copy(0.1f),
            ),
            singleLine = true
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = { Text("Department") }, // Hint text

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Color(0xff000000).copy(0.1f),
                unfocusedTextColor = Color(0xff000000).copy(0.1f),
                focusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                unfocusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                focusedIndicatorColor = Color(0xff000000).copy(0.1f),
                unfocusedIndicatorColor = Color(0xff000000).copy(0.1f),
            ),
            singleLine = true
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = { Text("Team Name") }, // Hint text

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Color(0xff000000).copy(0.1f),
                unfocusedTextColor = Color(0xff000000).copy(0.1f),
                focusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                unfocusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                focusedIndicatorColor = Color(0xff000000).copy(0.1f),
                unfocusedIndicatorColor = Color(0xff000000).copy(0.1f),
            ),
            singleLine = true
        )
        
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = { Text("Supervised By") }, // Hint text

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Color(0xff000000).copy(0.1f),
                unfocusedTextColor = Color(0xff000000).copy(0.1f),
                focusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                unfocusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                focusedIndicatorColor = Color(0xff000000).copy(0.1f),
                unfocusedIndicatorColor = Color(0xff000000).copy(0.1f),
            ),
            singleLine = true
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = { Text("Phone Number") }, // Hint text

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Color(0xff000000).copy(0.1f),
                unfocusedTextColor = Color(0xff000000).copy(0.1f),
                focusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                unfocusedPlaceholderColor = Color(0xff000000).copy(0.3f),
                focusedIndicatorColor = Color(0xff000000).copy(0.1f),
                unfocusedIndicatorColor = Color(0xff000000).copy(0.1f),
            ),
            singleLine = true
        )
        Button(
            onClick = { /*navigationService.navigateToInOut()*/},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 16.dp),
            //.align(Alignment.BottomCenter), // Adds space above the button
            colors = ButtonDefaults.buttonColors(containerColor = ColorService.primaryColor),
            shape = RoundedCornerShape(10.dp), // Border radius for the button
            //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue) // Button background color
        ) {
            Text(text = "Update", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) // Button text
        }
    }
}