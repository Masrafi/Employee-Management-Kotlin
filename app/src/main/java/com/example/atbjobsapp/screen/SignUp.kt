package com.example.atbjobsapp.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.atbjobsapp.service.NavigationService
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.res.painterResource
import com.example.atbjobsapp.R
import com.example.design.service.ColorService
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Close
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip

import androidx.compose.ui.window.Dialog


@Composable
fun SignUp(navController: NavController){
    val navigationService = NavigationService(navController)
    var text by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(text = "Sing Up for Better Experience", fontSize = 24.sp, color = Color(0xff414042))
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, top = 30.dp),
            placeholder = { Text("Search here...") }, // Hint text
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.account),
                    contentDescription = "Search icon",
                    tint = Color(0xff000000).copy(0.3f)
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = ColorService.primaryColor,
                unfocusedTextColor = ColorService.primaryColor,
                focusedPlaceholderColor = ColorService.primaryColor,
                unfocusedPlaceholderColor = ColorService.primaryColor,
                focusedIndicatorColor = ColorService.primaryColor,
                unfocusedIndicatorColor = ColorService.primaryColor
            ),
            singleLine = true
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = { Text("Search here...") }, // Hint text
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.email),
                    contentDescription = "Search icon"
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = ColorService.primaryColor,
                unfocusedTextColor = ColorService.primaryColor,
                focusedPlaceholderColor = ColorService.primaryColor,
                unfocusedPlaceholderColor = ColorService.primaryColor,
                focusedIndicatorColor = ColorService.primaryColor,
                unfocusedIndicatorColor = ColorService.primaryColor
            ),
            singleLine = true
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = { Text("Search here...") }, // Hint text
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.lock),
                    contentDescription = "Search icon"
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = ColorService.primaryColor,
                unfocusedTextColor = ColorService.primaryColor,
                focusedPlaceholderColor = ColorService.primaryColor,
                unfocusedPlaceholderColor = ColorService.primaryColor,
                focusedIndicatorColor = ColorService.primaryColor,
                unfocusedIndicatorColor = ColorService.primaryColor
            ),
            singleLine = true
        )


        Button(
            onClick = {showDialog = true},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 16.dp),
            //.align(Alignment.BottomCenter), // Adds space above the button
            colors = ButtonDefaults.buttonColors(containerColor = ColorService.primaryColor),
            shape = RoundedCornerShape(10.dp), // Border radius for the button
            //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue) // Button background color
        ) {
            Text(text = "Sign Up", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) // Button text
        }
        // Dialog UI
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth()
                ) {
                    // Close Icon
                    IconButton(
                        onClick = { showDialog = false },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close"
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(24.dp)
                            .align(Alignment.Center)
                    ) {
                        Text("Your registration is completed...", style = MaterialTheme.typography.titleLarge)

                        Spacer(modifier = Modifier.height(16.dp))

                        Image(
                            painter = painterResource(id = R.drawable.popup), // Replace with your image
                            contentDescription = "Sample Image",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text("Wait for verification! After verify you will get a email.")
                    }
                }
            }
        }
       Row() {
           Text("Already have an account? ", fontSize = 15.sp, color = Color(0xff414042))
           TextButton(onClick = { navigationService.navigateToLogin() }) {
               Text("Sing In", fontSize = 15.sp, color = Color(0xff414042))
           }
       }

        Button(
            onClick = { navigationService.navigateToSignUp() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 20.dp)
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google", modifier = Modifier.size(40.dp).padding(end = 10.dp))
                //androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google")
                Text(text = "Continue With Google", color = Color(0xff414042), fontSize = 19.sp, modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) // Button text
            }
        }
        
    }
}