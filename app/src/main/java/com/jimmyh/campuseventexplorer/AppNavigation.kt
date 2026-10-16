package com.jimmyh.campuseventexplorer

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.jimmyh.campuseventexplorer.data.CampusEvent
import com.jimmyh.campuseventexplorer.data.EventRepository

@Composable
fun CampusEventNavHost(
    navController: NavHostController,
    repository: EventRepository,
) {
    NavHost(navController = navController, startDestination = EventList) {
        composable<EventList> {
            // The search state now lives inside this destination.
            var query by rememberSaveable { mutableStateOf("") }
            val visibleEvents = remember(query) {
                repository.events.filter {
                    it.title.contains(query, ignoreCase = true) ||
                        it.category.contains(query, ignoreCase = true)
                }
            }
            EventListScreen(
                events = visibleEvents,
                query = query,
                onQueryChange = { query = it },
                onEventSelected = { eventId ->
                    navController.navigate(EventDetail(eventId))
                },
            )
        }

        composable<EventDetail> { backStackEntry ->
            val route = backStackEntry.toRoute<EventDetail>()
            val event = repository.findEvent(route.eventId)
            val context = LocalContext.current

            EventDetailScreen(
                event = event,
                onBack = {
                    // popBackStack() returns false if there is nothing to pop,
                    // so fall back to the list instead of doing nothing.
                    if (!navController.popBackStack()) {
                        navController.navigate(EventList)
                    }
                },
                onShare = { if (event != null) context.shareEvent(event) },
            )
        }
    }
}

private fun Context.shareEvent(event: CampusEvent) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, event.title)
        putExtra(Intent.EXTRA_TEXT, "${event.title} — ${event.time} — ${event.location}")
    }
    startActivity(Intent.createChooser(sendIntent, "Share event"))
}
