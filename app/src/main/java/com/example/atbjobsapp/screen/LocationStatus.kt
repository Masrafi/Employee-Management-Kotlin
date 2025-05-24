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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.atbjobsapp.R
import com.example.atbjobsapp.service.NavigationService
import com.example.design.service.ColorService
import kotlinx.coroutines.launch
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.DialogProperties
import androidx.compose.material3.ModalBottomSheetDefaults.properties
import androidx.compose.ui.layout.ContentScale

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LocationStatus(navController: NavController){
    val navigationService = NavigationService(navController)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    var showDialog by remember { mutableStateOf(true) }
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
                        Row() {
                            Icon(
                                painter = painterResource(id = R.drawable.alert),
                                contentDescription = "Location"
                            )
                            //Text(text = "Your Location: Block C, 24/A Tajmahal Road (Ring Road, Near Shia Mosque, Dhaka 1207")  
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color(0xff414042),
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 20.sp
                                        )
                                    ) {
                                        append("Status: ")
                                    }
                                    withStyle(
                                        style = SpanStyle(
                                            color = ColorService.redColor.copy(0.6f),
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 20.sp
                                        )
                                    ) {
                                        append("You are not in office range")
                                    }
                                },
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Image(painter = painterResource(id = R.drawable.map), contentDescription = "Map", contentScale = ContentScale.Crop, // or Fit, FillBounds depending on your need
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp))
                        if (showDialog) {
                            Dialog(onDismissRequest = { showDialog = false}, 
                                properties = DialogProperties(
                                    dismissOnClickOutside = false, 
                                    dismissOnBackPress = false
                            )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                                        .fillMaxWidth()
                                ) {
//                                    // Close Icon
//                                    IconButton(
//                                        onClick = { showDialog = false },
//                                        modifier = Modifier
//                                            .align(Alignment.TopEnd)
//                                            .padding(5.dp)
//                                    ) {
//                                        androidx.compose.material3.Icon(
//                                            imageVector = Icons.Default.Close, 
//                                            contentDescription = "Close"
//                                        )
//                                    }

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .padding(24.dp)
                                            .align(Alignment.Center)
                                    ) {
                                        Text("Do you want to change your location?", style = MaterialTheme.typography.titleLarge)

                                        Spacer(modifier = Modifier.height(16.dp))

                                        Row() {
                                            Button(
                                                onClick = {navigationService.navigateToSetLocation() },
                                                modifier = Modifier
                                                    .height(40.dp)
                                                    .width(100.dp),
                                                    //.padding(top = 30.dp, bottom = 16.dp),
                                                //.align(Alignment.BottomCenter), // Adds space above the button
                                                colors = ButtonDefaults.buttonColors(containerColor = ColorService.primaryColor),
                                                shape = RoundedCornerShape(10.dp), // Border radius for the button
                                                //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue) // Button background color
                                            ) {
                                                Text(text = "Yes", color = Color.White, fontSize = 18.sp, /*modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)*/) // Button text
                                            }
                                            Spacer(modifier = Modifier.width(20.dp))
                                            Button(
                                                onClick = {showDialog = false},
                                                modifier = Modifier
                                                    .height(40.dp)
                                                    .width(100.dp),
                                                    //.padding(top = 30.dp, bottom = 16.dp),
                                                //.align(Alignment.BottomCenter), // Adds space above the button
                                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff9E0404)),
                                                shape = RoundedCornerShape(10.dp), // Border radius for the button
                                                //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue) // Button background color
                                            ) {
                                                Text(text = "No", color = Color.White, fontSize = 18.sp, /*modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)*/) // Button text
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Row() {
                            Icon(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = "Location"
                            )
                            //Text(text = "Your Location: Block C, 24/A Tajmahal Road (Ring Road, Near Shia Mosque, Dhaka 1207")  
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color(0xff414042),
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 20.sp
                                        )
                                    ) {
                                        append("Your Location: ")
                                    }
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color(0xff414042).copy(0.6f),
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 20.sp
                                        )
                                    ) {
                                        append("Block C, 24/A Tajmahal Road (Ring Road, Near Shia Mosque, Dhaka 1207")
                                    }
                                },
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                            )
                        }
                        Spacer(modifier = Modifier.height(100.dp))
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xff414042),
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 20.sp
                                    )
                                ) {
                                    append("Note: Please go inside Office range then ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = ColorService.redColor.copy(0.6f),
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp
                                    )
                                ) {
                                    append("try again!")
                                }
                            },
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                        )
                    }
            }
        )
    }
}