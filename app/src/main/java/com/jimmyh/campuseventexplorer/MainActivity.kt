package com.jimmyh.campuseventexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController


import com.jimmyh.campuseventexplorer.data.EventRepository
import com.jimmyh.campuseventexplorer.ui.theme.CampusEventExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusEventExplorerTheme {
                CampusEventExplorerApp()
            }
        }
    }
}

@Composable
fun CampusEventExplorerApp() {
    val navController = rememberNavController()
    val repository = remember { EventRepository() }
    CampusEventNavHost(navController = navController, repository = repository)
}