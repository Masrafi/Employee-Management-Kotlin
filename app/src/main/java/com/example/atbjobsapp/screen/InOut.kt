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
import androidx.compose.foundation.border

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InOut(navController: NavController) {
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
//                    actions = {
//                        scope.launch { drawerState.open()}
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
                        Spacer(modifier = Modifier.height(20.dp))
                        Text("Hi Masrafi Aanm!", fontSize = 20.sp, fontWeight = FontWeight.Normal,modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
                        Spacer(modifier = Modifier.height(30.dp))
                        TimeAndDateDisplay()
                        Spacer(modifier = Modifier.height(70.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxSize(), // fills parent space
                            horizontalArrangement = Arrangement.Center, // centers content horizontally
                            //verticalAlignment = Alignment.CenterHorizontally // centers content vertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                                    .width(100.dp)
                                    .height(100.dp)
                                    .clickable { navigationService.navigateToLocationStatus() }
                                    .shadow(
                                        elevation = 5.dp,
                                        shape = RoundedCornerShape(10.dp), // Ensures shadow follows rounded corners
                                        spotColor = Color.Black.copy(alpha = 0.08f)
                                    )
                                    .border(
                                        0.dp,
                                        Color.Transparent,
                                        RoundedCornerShape(10.dp)
                                    ) // Adds a border
                                    .background(ColorService.primaryColor)
                            ){
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(), // fills parent space
                                    verticalArrangement = Arrangement.Center, // centers content vertically
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    androidx.compose.material.Icon(
                                        painter = painterResource(id = R.drawable.`in`),
                                        contentDescription = "in", tint = ColorService.whiteColor
                                    )
                                    Text("In", fontSize = 24.sp, color = ColorService.whiteColor)
                                }
                                
                            }
                            Box(
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                                    .width(100.dp)
                                    .height(100.dp)
                                    .clickable { navigationService.navigateToLocationStatus() }
                                    .shadow(
                                        elevation = 5.dp,
                                        shape = RoundedCornerShape(10.dp), // Ensures shadow follows rounded corners
                                        spotColor = Color.Black.copy(alpha = 0.08f)
                                    )
                                    .border(
                                        0.dp,
                                        Color.Transparent,
                                        RoundedCornerShape(10.dp)
                                    ) // Adds a border
                                    .background(Color(0xff414042))
                            ){
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(), // fills parent space
                                    verticalArrangement = Arrangement.Center, // centers content vertically
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    androidx.compose.material.Icon(
                                        painter = painterResource(id = R.drawable.out),
                                        contentDescription = "in", tint = ColorService.whiteColor
                                    )
                                    Text("Out", fontSize = 24.sp, color = ColorService.whiteColor)
                                }
                            }
                        }
                    }
                    
                }

            }
        )
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun TimeAndDateDisplay() {
//    // Get current time and date
//    val now = LocalDateTime.now()
//
//    val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.getDefault())
//    val dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMM dd", Locale.getDefault())
//
//    val timeText = now.format(timeFormatter)
//    val dateText = now.format(dateFormatter)
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = timeText,
//            fontSize = 44.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xff414042)
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            text = dateText,
//            fontSize = 26.sp,
//            color = Color(0xff414042)
//        )
//    }
//}



//@Composable
//fun DrawerContent(
//    navController: NavHostController,
//    drawerState: DrawerState
//) {
//    val scope = rememberCoroutineScope()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize() // fill parent from ModalDrawerSheet
//            .padding(0.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(143.dp)
//                .background(Color(0xff73AB6B))
//                .padding(16.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            androidx.compose.material.Icon(painter = painterResource(id = R.drawable.user), contentDescription = "User")
//        }
//
//        DrawerBody(title = "Home", image = R.drawable.home)
//        DrawerBody(title = "Issues", image = R.drawable.desk)
//        DrawerBody(title = "Incident", image = R.drawable.desk_alt)
//        DrawerBody(title = "Leaves", image = R.drawable.notebook)
//        DrawerBody(title = "Change Password", image = R.drawable.bag)
//        DrawerBody(title = "Log Out", image = R.drawable.sign_out_squre)
//    }
//}


//@Composable
//fun DrawerBody(
//    title: String,
//    image: Int
//){
//    Row(
//        modifier = Modifier.padding(all = 16.dp)
//    ) {
//        Icon(painter = painterResource(id = image), contentDescription = "Desk", modifier = Modifier.size(30.dp))
//        Spacer(modifier = Modifier.width(10.dp))
//        Text(
//            text = title,
//            fontSize = 21.sp,
//            fontWeight = FontWeight.Bold,
//            color=Color(0xff414042),
//            modifier = Modifier
//                .fillMaxWidth()
////                .clickable {
////                    navController.navigate("Home".lowercase())
////                    scope.launch { drawerState.close() }
////                }
//            //.padding(12.dp)
//        )
//    }
//}