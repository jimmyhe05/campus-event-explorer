package com.jimmyh.campuseventexplorer.data

class EventRepository {
    val events: List<CampusEvent> = listOf(
        CampusEvent(
            id = 1L,
            title = "Mobile Development Meetup",
            category = "Technology",
            location = "CAS 214",
            time = "Tuesday 6:30 PM",
            description = "Students demo the Android and iOS apps they are building this semester.",
        ),
        CampusEvent(
            id = 2L,
            title = "Fall Career Fair",
            category = "Career",
            location = "GSU Metcalf Ballroom",
            time = "Wednesday 11:00 AM",
            description = "More than 80 employers recruiting for internships and full-time roles.",
        ),
        CampusEvent(
            id = 3L,
            title = "Intro to Machine Learning Workshop",
            category = "Technology",
            location = "CDS 1101",
            time = "Thursday 4:00 PM",
            description = "A hands-on workshop covering regression, classification, and model evaluation.",
        ),
        CampusEvent(
            id = 4L,
            title = "Open Mic Night",
            category = "Arts",
            location = "Student Village Lounge",
            time = "Friday 8:00 PM",
            description = "Poetry, music, and comedy from student performers.",
        ),
        CampusEvent(
            id = 5L,
            title = "Intramural Soccer Finals",
            category = "Sports",
            location = "Nickerson Field",
            time = "Saturday 2:00 PM",
            description = "The top two intramural teams compete for the fall championship.",
        ),
        CampusEvent(
            id = 6L,
            title = "Mindfulness and Stress Relief",
            category = "Wellness",
            location = "FitRec Studio 3",
            time = "Monday 12:30 PM",
            description = "A guided 45-minute session on breathing and meditation techniques.",
        ),
        CampusEvent(
            id = 7L,
            title = "Hackathon Kickoff",
            category = "Technology",
            location = "Photonics Center 906",
            time = "Friday 6:00 PM",
            description = "Form teams, hear the challenge prompts, and meet the mentors.",
        ),
        CampusEvent(
            id = 8L,
            title = "International Food Festival",
            category = "Culture",
            location = "Marsh Plaza",
            time = "Sunday 1:00 PM",
            description = "Student cultural clubs serve dishes from around the world.",
        ),
    )

    // Returns null when no event has this ID, so the detail screen can show "Event unavailable".
    fun findEvent(eventId: Long): CampusEvent? = events.firstOrNull { it.id == eventId }
}
