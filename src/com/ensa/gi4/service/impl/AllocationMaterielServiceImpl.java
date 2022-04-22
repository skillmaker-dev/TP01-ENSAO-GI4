package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.IMaterielDAO;
import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.eventshandlers.ApplicationPublisher;
import com.ensa.gi4.eventshandlers.Event;
import com.ensa.gi4.eventshandlers.EventType;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component("allocationMaterielService")
public class AllocationMaterielServiceImpl implements AllocationMaterielService {

    private IMaterielDAO materiel;
    private ApplicationPublisher applicationPublisher;


    @Autowired
    public void setMaterielDao(IMaterielDAO materiel) {
        // injection par accesseur
        this.materiel = materiel;
    }
    @Autowired
    public void setApplicationPublisher(ApplicationPublisher applicationPublisher)
    {
        this.applicationPublisher = applicationPublisher;
    }


    @Override
    public void allouerMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer id de materiel a allouer");
        int id = scanner.nextInt();
        System.out.println("Veuillez entrer nombre de jours");
        int jrs = scanner.nextInt();

        //System.out.println("Materiel " + this.materiel.getMateriel(id).getName() + " Alloué pour " + jrs + " Jours");
        applicationPublisher.publish(new Event(this.materiel.getMateriel(id), EventType.BORROW));
        this.materiel.addToMaterielAlloue(id);
        this.materiel.deleteMateriel(id);

    }

    @Override
    public void rendreMateriel() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer id de materiel a rendre");
        int id = scanner.nextInt();
         Materiel m =  this.materiel.getFromMaterielAlloue(id);
       this.materiel.removeFromMaterielAlloue(id);
       this.materiel.addMateriel(m);

        applicationPublisher.publish(new Event(this.materiel.getMateriel(id), EventType.RETURN));
    }

    @Override
    public void listerMateriel() {
        for (Materiel m:
                this.materiel.getMaterielsAlloue()) {
            //System.out.println("Name: " + m.getName() + " Id: " + m.getId());
            applicationPublisher.publish(new Event(m, EventType.LIST));
        }
    }


}
