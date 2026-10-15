package com.jimmyh.campuseventexplorer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jimmyh.campuseventexplorer.data.CampusEvent
import com.jimmyh.campuseventexplorer.data.EventRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: CampusEvent?,          // nullable: the ID might not match any event
    onBack: () -> Unit,
    onShare: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(event?.title ?: "Event") },
                navigationIcon = {
                    IconButton(onClick = onBack) {           // the app-bar Up button
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Navigate up")
                    }
                },
            )
        },
    ) { innerPadding ->
        if (event == null) {
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding).padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("Event unavailable", style = MaterialTheme.typography.headlineSmall)
                Text("This event may have been removed or the link is out of date.",
                    textAlign = TextAlign.Center)
                Button(onClick = onBack) { Text("Return to events") }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())   // so landscape can scroll
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(event.category, color = MaterialTheme.colorScheme.primary)
                Text(event.title, style = MaterialTheme.typography.headlineMedium)
                Text("When: ${event.time}", style = MaterialTheme.typography.titleMedium)
                Text("Where: ${event.location}", style = MaterialTheme.typography.titleMedium)
                Text(event.description, style = MaterialTheme.typography.bodyLarge)
                Button(onClick = onShare) {
                    Icon(Icons.Filled.Share, contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp))
                    Text("Share event")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailPreview() {
    EventDetailScreen(EventRepository().events.first(), onBack = {}, onShare = {})
}

@Preview(showBackground = true)
@Composable
private fun UnavailablePreview() {
    EventDetailScreen(event = null, onBack = {}, onShare = {})
}