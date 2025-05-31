package com.example.atbjobsapp.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.IconButton
import androidx.navigation.NavController
import com.example.atbjobsapp.R
import com.example.atbjobsapp.service.NavigationService
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.navigation.NavHostController
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import kotlinx.coroutines.launch
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.DrawerValue
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import com.example.design.service.ColorService
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.window.Dialog
import android.util.Log
import androidx.compose.material3.TextButton
import androidx.compose.ui.window.DialogProperties


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeStatus(navController: NavController) {
    val items = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")
    val navigationService = NavigationService(navController)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
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
                //DrawerContent(navigationService, navController, drawerState)
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
                Box() {
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(start = 16.dp, end = 16.dp)
                            .fillMaxSize()
                    ) {
                        TimeAndDateDisplay()
                        if (showDialog) {
                            Dialog(onDismissRequest = { showDialog= false },
                                properties = DialogProperties(
                                    dismissOnClickOutside = false,
                                    dismissOnBackPress = false
                                )
                                ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        //.background(Color(0xFFB0B0B0))
                                        .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(12.dp)) // light gray
                                        .padding(16.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                                        verticalArrangement = Arrangement.Center,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        // Cancel icon at the top-right
//                Box(
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(bottom = 8.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.cancel,
//                        contentDescription = "Cancel",
//                        modifier = Modifier
//                            .align(Alignment.TopEnd)
//                            .clickable { onDismiss() }
//                    )
//                }

                                        // List of 10 clickable texts
                                        Column {
                                            items.take(10).forEach { item ->
                                                TextButton(onClick = {
                                                    print(item)
                                                    navigationService.navigateToHome(item)
                                                    // Handle click
                                                }) {
                                                    Text(
                                                        text = item,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .align(Alignment.CenterVertically)
                                                            .padding(vertical = 8.dp),
                                                        color = Color.Black,
                                                        fontSize = 16.sp
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize(), // fills parent space
                            //horizontalArrangement = Arrangement.Center, // centers content horizontally
                            verticalAlignment = Alignment.CenterVertically // centers content vertically
                        ) {
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
                                        append("Location: ")
                                    }
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color(0xff414042).copy(0.6f),
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 20.sp
                                        )
                                    ) {
                                        append("Set your location")
                                    }
                                },
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()

                            .padding(top = 30.dp, start = 16.dp, bottom = 100.dp, end = 16.dp)
                            .background(ColorService.whiteColor)
                            .shadow(elevation = 5.dp, spotColor = Color.Transparent)
                            .clip(RoundedCornerShape(15.dp))
                            .align(Alignment.BottomCenter), // Adds space above the button
                    ) {
                        Row(

                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(horizontal = 16.dp),
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.clock),
                                    contentDescription = "Clock",
                                    tint = Color(0xff73AB6B),
                                    modifier = Modifier.size(60.dp)
                                )
                                Text(text = "--:--", fontSize = 21.sp, color = Color(0xff414042), fontWeight = FontWeight.Bold)
                                Text(text = "Check In")
                            }
                            Spacer(modifier = Modifier.width(30.dp))
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.clock),
                                    contentDescription = "Clock",
                                    tint = Color(0xff73AB6B),
                                    modifier = Modifier.size(60.dp)
                                )
                                Text(text = "--:--", fontSize = 21.sp, color = Color(0xff414042), fontWeight = FontWeight.Bold)
                                Text(text = "Check Out")
                            }
                            Spacer(modifier = Modifier.width(30.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.clock),
                                    contentDescription = "Clock",
                                    tint = Color(0xff73AB6B),
                                    modifier = Modifier.size(60.dp)
                                )
                                Text(text = "--:--", fontSize = 21.sp, color = Color(0xff414042), fontWeight = FontWeight.Bold)
                                Text(text = "Working Time")
                            }
                        }
                    }
                }

            }
        )
    }
}
@Composable
fun TextSelectionDialog(
    items: List<String>,
    onDismiss: () -> Unit,
    onItemSelected: (String) -> Unit
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Column {
                // Cancel icon at the top-right
//                Box(
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(bottom = 8.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.cancel,
//                        contentDescription = "Cancel",
//                        modifier = Modifier
//                            .align(Alignment.TopEnd)
//                            .clickable { onDismiss() }
//                    )
//                }

                // List of 10 clickable texts
                Column {
                    items.take(10).forEach { item ->
                        Text(
                            text = item,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    Log.d("DialogSelection", "Selected value: $item")
                                    print(item);
                                    onItemSelected(item)
                                }
                                .padding(vertical = 8.dp),
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}
