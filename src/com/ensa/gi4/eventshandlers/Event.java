package com.ensa.gi4.eventshandlers;


import com.ensa.gi4.modele.Materiel;
import org.springframework.context.ApplicationEvent;

public class Event<T extends Materiel> extends ApplicationEvent {

    private final EventType eventType;

    public Event(T source, EventType eventType) {
        super(source);
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }
}