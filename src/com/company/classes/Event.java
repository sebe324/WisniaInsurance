package com.company.classes;

import java.util.List;

public class Event {
    private int id;
    private String eventDate;
    private List<Damage> damages;
    private String eventPlace;
    private String courseOfEvents;

    public Event(int id, String eventDate, List<Damage> damages, String eventPlace, String courseOfEvents) {
        this.id = id;
        this.eventDate = eventDate;
        this.damages = damages;
        this.eventPlace = eventPlace;
        this.courseOfEvents = courseOfEvents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public void setDamages(List<Damage> damages) {
        this.damages = damages;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getCourseOfEvents() {
        return courseOfEvents;
    }

    public void setCourseOfEvents(String courseOfEvents) {
        this.courseOfEvents = courseOfEvents;
    }
}
