package com.jimmyh.campuseventexplorer

import kotlinx.serialization.Serializable

@Serializable data object EventList

@Serializable data class EventDetail(val eventId: Long)