package com.arshtestproject.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.arshtestproject.ui.main.navigation.ScreenRouteModel
import com.arshtestproject.ui.main.feature.home_feature.HomeScreen
import com.arshtestproject.ui.main.navigation.BottomNavigationBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color.Transparent
    ) { innerPadding ->

        val graph =
            navController.createGraph(startDestination = ScreenRouteModel.Home.rout) {
                composable(route = ScreenRouteModel.Home.rout) {
                    HomeScreen()
                }

                composable(route = ScreenRouteModel.Cart.rout) {

                }
                composable(route = ScreenRouteModel.Setting.rout) {

                }

                composable(route = ScreenRouteModel.Profile.rout) {

                }
            }

        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )

    }
}