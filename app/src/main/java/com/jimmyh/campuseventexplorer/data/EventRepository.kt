package com.jimmyh.campuseventexplorer.data

class EventRepository {
    val events: List<CampusEvent> = listOf(
        CampusEvent(1L, "Mobile Development Meetup", "Technology", "CAS 214", "Tuesday 6:30 PM",
            "Students demo the Android and iOS apps they are building this semester."),
        CampusEvent(2L, "Fall Career Fair", "Career", "GSU Metcalf Ballroom", "Wednesday 11:00 AM",
            "More than 80 employers recruiting for internships and full-time roles."),
        CampusEvent(3L, "Intro to Machine Learning Workshop", "Technology", "CDS 1101", "Thursday 4:00 PM",
            "A hands-on workshop covering regression, classification, and model evaluation."),
        CampusEvent(4L, "Open Mic Night", "Arts", "Student Village Lounge", "Friday 8:00 PM",
            "Poetry, music, and comedy from student performers."),
        CampusEvent(5L, "Intramural Soccer Finals", "Sports", "Nickerson Field", "Saturday 2:00 PM",
            "The top two intramural teams compete for the fall championship."),
        CampusEvent(6L, "Mindfulness and Stress Relief", "Wellness", "FitRec Studio 3", "Monday 12:30 PM",
            "A guided 45-minute session on breathing and meditation techniques."),
        CampusEvent(7L, "Hackathon Kickoff", "Technology", "Photonics Center 906", "Friday 6:00 PM",
            "Form teams, hear the challenge prompts, and meet the mentors."),
        CampusEvent(8L, "International Food Festival", "Culture", "Marsh Plaza", "Sunday 1:00 PM",
            "Student cultural clubs serve dishes from around the world."),
    )

    // Returns null when no event has this ID.
    fun findEvent(eventId: Long): CampusEvent? = events.firstOrNull { it.id == eventId }
}