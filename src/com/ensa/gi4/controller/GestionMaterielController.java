package com.ensa.gi4.controller;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.List;
import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;
    private AllocationMaterielService allocationMaterielService;

    public void listerMateriel() {
        //gestionMaterielService.getAllMateriels();
        for (Materiel m:
                gestionMaterielService.getAllMateriels()) {
            System.out.println(m.getName());
        }
    }
    public void ajouterMateriel(Materiel materiel) { gestionMaterielService.addMateriel(materiel); }
    public void supprimerMateriel(int id) {
        System.out.println("Materiel " + gestionMaterielService.getMateriel(id).getName() + " Supprimé");
        gestionMaterielService.deleteMateriel(id);
    }
    public void allouerMateriel(int id,int nbrejrs) { allocationMaterielService.allouerMateriel(id,nbrejrs);}
    public void rendreMateriel(int id) { allocationMaterielService.rendreMateriel(id);}
    public void afficherMenu() {
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour supprimer un matériel, entrer 3");
        System.out.println("4- pour allouer un matériel, entrer 4");
        System.out.println("5- pour rendre un matériel, entrer 5");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            //traitement pour lire le donnees user
            System.out.println("Veuillez entrer type de materiel a ajouter, 1 pour livre, 2 pour chaise");
            int type = scanner.nextInt();

            if(type == 1)
            {
                System.out.println("id ?");
                int id = scanner.nextInt();
                System.out.println("name ?");
                String nom = scanner.next();
                System.out.println("author ?");
                String author = scanner.next();
                System.out.println("year ?");
                String year = scanner.next();
                System.out.println("plot ?");
                String plot = scanner.next();
                Livre l = new Livre(id,nom,author,year ,plot);
                ajouterMateriel(l);
            }
            else if(type == 2)
            {
                System.out.println("id ?");
                int id = scanner.nextInt();
                System.out.println("name ?");
                String nom = scanner.next();
                System.out.println("type ?");
                String ctype = scanner.next();
                System.out.println("price ?");
                double price = scanner.nextDouble();

                Chaise c = new Chaise(id,nom,ctype,price);
                ajouterMateriel(c);
            }


        } else if ("3".equals(next)) {
            //traitement pour lire donnees
            System.out.println("Veuillez entrer id de materiel a supprimer");
            int id = scanner.nextInt();
            supprimerMateriel(id);
        } else if ("4".equals(next)) {
            //traitement pour lire donnees
            System.out.println("Veuillez entrer id de materiel a allouer");
            int id = scanner.nextInt();
            System.out.println("Veuillez entrer nombre de jours");
            int jrs = scanner.nextInt();
            allouerMateriel(id,jrs);
        }
        else if ("5".equals(next)) {
            //traitement pour lire donnees
            rendreMateriel(2);
        } else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }

    public void setAllocationMaterielService(AllocationMaterielService allocationMaterielService) {
        // injection par accesseur
        this.allocationMaterielService = allocationMaterielService;
    }
}
