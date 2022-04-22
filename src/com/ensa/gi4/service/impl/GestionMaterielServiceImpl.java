package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.IMaterielDAO;
import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.eventshandlers.ApplicationPublisher;
import com.ensa.gi4.eventshandlers.Event;
import com.ensa.gi4.eventshandlers.EventType;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component("gestionMaterielService")
public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here

    private IMaterielDAO materiel;
    private ApplicationPublisher applicationPublisher;

    @Autowired
    public void setMaterielDao(IMaterielDAO materiel) {
        // injection par accesseur et en utilisant l'interface
        this.materiel = materiel;
    }

    @Autowired
    public void setApplicationPublisher(ApplicationPublisher applicationPublisher)
    {
        this.applicationPublisher = applicationPublisher;
    }



    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void getAllMateriels() {
        for (Materiel m:
                materiel.getAllMateriels()) {
            applicationPublisher.publish(new Event(m, EventType.LIST));
            //System.out.println("Name: " + m.getName() + " Id: " + m.getId());
        }
    }

    @Override
    public void addMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer type de materiel a ajouter, 1 pour livre, 2 pour chaise");
        int type = scanner.nextInt();

        Random random = new Random();
        if(type == 1)
        {
            int id = random.nextInt(99999 - 1) + 1;
            System.out.println("name ?");
            String nom = scanner.next();
            System.out.println("author ?");
            String author = scanner.next();
            System.out.println("year ?");
            String year = scanner.next();
            System.out.println("plot ?");
            String plot = scanner.next();
            Livre l = new Livre(id,nom,author,year ,plot);
            this.materiel.addMateriel(l);
            applicationPublisher.publish(new Event(l, EventType.ADD));
        }
        else if(type == 2)
        {
            int id = random.nextInt(99999 - 1) + 1;
            System.out.println("name ?");
            String nom = scanner.next();
            System.out.println("type ?");
            String ctype = scanner.next();
            System.out.println("price ?");
            double price = scanner.nextDouble();

            Chaise c = new Chaise(id,nom,ctype,price);
            this.materiel.addMateriel(c);
            applicationPublisher.publish(new Event(c, EventType.ADD));
        }
    }

    @Override
    public void deleteMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer id de materiel a supprimer");
        int id = scanner.nextInt();
        applicationPublisher.publish(new Event(this.materiel.getMateriel(id), EventType.REMOVE));
        //System.out.println("Materiel " + this.materiel.getMateriel(id).getName() + " Supprimé");
        this.materiel.deleteMateriel(id);
    }

    @Override
    public void getMateriel(int id) {
        Materiel m = materiel.getMateriel(id);
        applicationPublisher.publish(new Event(m, EventType.LIST));
        //1System.out.println("Name: " + m.getName() + " Id: " + m.getId());
    }

    @Override
    public void updateMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer id de materiel a modifier");
        int id = scanner.nextInt();
        Materiel mat = this.materiel.getMateriel(id);

        if(mat instanceof Livre)
        {
            System.out.println("name ?");
            String nom = scanner.next();
            System.out.println("author ?");
            String author = scanner.next();
            System.out.println("year ?");
            String year = scanner.next();
            System.out.println("plot ?");
            String plot = scanner.next();
            Livre l = new Livre(id,nom,author,year ,plot);
            this.materiel.updateMateriel(id,l);
        }
        else if(mat instanceof Chaise)
        {
            System.out.println("name ?");
            String nom = scanner.next();
            System.out.println("type ?");
            String ctype = scanner.next();
            System.out.println("price ?");
            double price = scanner.nextDouble();

            Chaise c = new Chaise(id,nom,ctype,price);
            this.materiel.updateMateriel(id,c);
        }

        applicationPublisher.publish(new Event(mat, EventType.EDIT));


        this.materiel.updateMateriel(id,mat);
    }
}
