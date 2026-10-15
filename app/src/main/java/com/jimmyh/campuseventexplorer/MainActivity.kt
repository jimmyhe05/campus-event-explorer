package com.jimmyh.campuseventexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue


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
    val repository = remember { EventRepository() }
    var query by rememberSaveable { mutableStateOf("") }


    val visibleEvents = repository.events.filter { event ->
        event.title.contains(query, ignoreCase = true) ||
                event.category.contains(query, ignoreCase = true)
    }

    EventListScreen(
        events = visibleEvents,
        query = query,
        onQueryChange = { query = it },
        onEventSelected = { },
    )
}