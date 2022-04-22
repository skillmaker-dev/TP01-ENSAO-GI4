package com.ensa.gi4.eventshandlers;

import com.ensa.gi4.modele.Materiel;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component("publisher")
public class ApplicationPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;

    }

    public <T extends Materiel> void  publish(Event<T> event) {
        applicationEventPublisher.publishEvent(event);

    }
}