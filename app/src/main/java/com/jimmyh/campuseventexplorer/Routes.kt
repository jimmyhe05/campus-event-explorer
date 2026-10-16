package com.jimmyh.campuseventexplorer

import kotlinx.serialization.Serializable

// Start destination: the searchable list of events.
@Serializable
data object EventList

// Detail destination. Carries only the event's ID, never the whole CampusEvent.
@Serializable
data class EventDetail(val eventId: Long)
