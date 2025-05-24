package com.example.atbjobsapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.atbjobsapp.R
import com.example.atbjobsapp.service.NavigationService
import com.example.design.service.ColorService
import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetLocation(navController: NavController){
    val navigationService = NavigationService(navController)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    var text by remember { mutableStateOf("") }
    //dropdown
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select item") }
    val options = listOf("Option 1", "Option 2", "Option 3")
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(280.dp) // custom width
                    .padding(0.dp), // remove padding
                drawerContainerColor = Color(0xffFFFFFF),
                drawerTonalElevation = 0.dp
            ) {
                DrawerContent(navigationService, navController, drawerState)
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Home", color = Color(0xffFFFFFF))
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xff73AB6B),
                        titleContentColor = Color(0xff73AB6B),
                    ),
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
//                actions = {
//                    scope.launch { drawerState.open()}
//                    },
                )
            },
            content = { innerPadding ->
                // Your screen content here, respecting inner padding
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(all = 16.dp)
                        .fillMaxSize()
                ) {
                    TimeAndDateDisplay()
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff414042),
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 20.sp
                                )
                            ) {
                                append("Location: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff414042),
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 20.sp
                                )
                            ) {
                                append("Set your location")
                            }
                        },
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded },
                    ) {
                        TextField(
                            value = selectedOption,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                                .background(Color.Transparent)
                                .border(
                                    width = 1.dp,
                                    color = ColorService.primaryColor,
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedTextColor = ColorService.primaryColor,
                                unfocusedTextColor = ColorService.primaryColor,
                                focusedPlaceholderColor = ColorService.primaryColor,
                                unfocusedPlaceholderColor = ColorService.primaryColor,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                            ),
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                            }
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            options.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        selectedOption = option
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp) // Set desired height here
                            .padding(bottom = 16.dp),
                        placeholder = { Text("Description*") }, // Update placeholder as needed
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedTextColor = ColorService.primaryColor,
                            unfocusedTextColor = ColorService.primaryColor,
                            focusedPlaceholderColor = ColorService.primaryColor,
                            unfocusedPlaceholderColor = ColorService.primaryColor,
                            focusedIndicatorColor = ColorService.primaryColor,
                            unfocusedIndicatorColor = ColorService.primaryColor,
                            disabledIndicatorColor = ColorService.primaryColor,
                        ),
                        maxLines = 5, // Allow multiple lines for description
                        singleLine = false // Important: must be false to support multi-line
                    )
                    Button(
                        onClick = { navigationService.navigateToHome()},
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
        )
    }
}