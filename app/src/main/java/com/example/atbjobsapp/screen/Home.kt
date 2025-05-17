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

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController) {
    val navigationService = NavigationService(navController)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
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
                DrawerContent(navController, drawerState)
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
                            .fillMaxSize()
                    ) {
                        TimeAndDateDisplay()

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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeAndDateDisplay() {
    // Get current time and date
    val now = LocalDateTime.now()

    val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.getDefault())
    val dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMM dd", Locale.getDefault())

    val timeText = now.format(timeFormatter)
    val dateText = now.format(dateFormatter)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = timeText,
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff414042)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = dateText,
            fontSize = 26.sp,
            color = Color(0xff414042)
        )
    }
}



@Composable
fun DrawerContent(
    navController: NavHostController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize() // fill parent from ModalDrawerSheet
            .padding(0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(143.dp)
                .background(Color(0xff73AB6B))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material.Icon(painter = painterResource(id = R.drawable.user), contentDescription = "User")
        }

        DrawerBody(title = "Home", image = R.drawable.home)
        DrawerBody(title = "Issues", image = R.drawable.desk)
        DrawerBody(title = "Incident", image = R.drawable.desk_alt)
        DrawerBody(title = "Leaves", image = R.drawable.notebook)
        DrawerBody(title = "Change Password", image = R.drawable.bag)
        DrawerBody(title = "Log Out", image = R.drawable.sign_out_squre)
    }
}


@Composable
fun DrawerBody(
    title: String,
    image: Int
){
    Row(
        modifier = Modifier.padding(all = 16.dp)
    ) {
        Icon(painter = painterResource(id = image), contentDescription = "Desk", modifier = Modifier.size(30.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color=Color(0xff414042),
            modifier = Modifier
                .fillMaxWidth()
//                .clickable {
//                    navController.navigate("Home".lowercase())
//                    scope.launch { drawerState.close() }
//                }
            //.padding(12.dp)
        )
    }
}