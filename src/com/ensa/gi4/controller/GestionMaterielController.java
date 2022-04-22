package com.ensa.gi4.controller;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
@Component("controller")
public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;
    private AllocationMaterielService allocationMaterielService;

    @Autowired
    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur et en utilisant l'interface
        this.gestionMaterielService = gestionMaterielService;
    }
    @Autowired
    public void setAllocationMaterielService(AllocationMaterielService allocationMaterielService) {
        // injection par accesseur et en utilisant l'interface
        this.allocationMaterielService = allocationMaterielService;
    }


    public void listerMateriel() {
        gestionMaterielService.getAllMateriels();
    }
    public void listerMaterielAlloue()
    {
        allocationMaterielService.listerMateriel();
    }
    public void ajouterMateriel() {
            gestionMaterielService.addMateriel();
        }
    public void supprimerMateriel() {
        gestionMaterielService.deleteMateriel();
    }
    public void allouerMateriel() {
        allocationMaterielService.allouerMateriel();
    }
    public void rendreMateriel() {
        allocationMaterielService.rendreMateriel();}

    public void modifierMateriel()
    {
       gestionMaterielService.updateMateriel();
    }
    public void afficherMenu() {
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour supprimer un matériel, entrer 3");
        System.out.println("4- pour allouer un matériel, entrer 4");
        System.out.println("5- pour rendre un matériel, entrer 5");
        System.out.println("6- pour modifier un matériel, entrer 6");
        System.out.println("7- pour lister materiels alloués 7");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
           ajouterMateriel();
        } else if ("3".equals(next)) {
            supprimerMateriel();
        } else if ("4".equals(next)) {
            allouerMateriel();
        }
        else if ("5".equals(next)) {
            rendreMateriel();
        }
        else if ("6".equals(next)) {
            modifierMateriel();
        }
        else if ("7".equals(next)) {
            listerMaterielAlloue();
        }else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }


}
