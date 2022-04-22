package com.ensa.gi4.eventshandlers;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ApplicationEventListener<T extends Materiel> implements ApplicationListener<Event<T>> {
    Logger logger = Logger.getLogger(ApplicationEventListener.class.getName());
    @Override
    public void onApplicationEvent(Event<T> event) {
        //Pour faire le logging
        //logger.log(Level.INFO,"Event triggered");
        //logger.log(Level.INFO,"event.getEventType() = " + event.getEventType());
        //logger.log(Level.INFO,"event.getSource() = " + event.getSource());

        EventType eventType = event.getEventType();
        Object eventSource = event.getSource();

        switch (eventType){
            case LIST -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("ID : " + livre.getId() + " , Nom : " + livre.getName());
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("ID : " + chaise.getId() + " , Nom : " + chaise.getName());
                }
            }
            case ADD -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("ID : " + livre.getId() + " Le livre " + livre.getName() + " est ajouté");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("ID : " + chaise.getId() + " La chaise " + chaise.getName() + " est ajoutée");
                }
            }
            case REMOVE -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("ID : " + livre.getId() + " Le livre " + livre.getName() + " est supprimé");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("ID : " + chaise.getId() +" La chaise " + chaise.getName() + " est supprimée");
                }
            }
            case EDIT -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("ID : " + livre.getId() + " Le livre " + livre.getName() + " est modifié");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("ID : " + chaise.getId() + " La chaise " + chaise.getName() + " est modifiée");
                }
            }
            case BORROW -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("ID : " + livre.getId() + " Le livre " + livre.getName() + " est alloué");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("ID : " + chaise.getId() + " La chaise " + chaise.getName() + " est bien alloue");
                }
            }
            case RETURN -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("ID : " + livre.getId() + " Le livre " + livre.getName() + " est rendu");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("ID : " + chaise.getId() + " La chaise " + chaise.getName() + " est rendue");
                }
            }
        }


    }
}