package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.ArrayList;
import java.util.List;

public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here

    private MaterielDAO materiel;


    public void setMaterielDao(MaterielDAO materiel) {
        // injection par accesseur
        this.materiel = materiel;
    }


    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public List<Materiel> getAllMateriels() {
        return materiel.getAllMateriels();
    }

    @Override
    public void addMateriel(Materiel materiel) {
        this.materiel.addMateriel(materiel);
    }

    @Override
    public void deleteMateriel(int id) {
        this.materiel.deleteMateriel(id);
    }

    @Override
    public Materiel getMateriel(int id) {
        return materiel.getMateriel(id);
    }

    @Override
    public void updateMateriel(int id, Materiel materiel) {
        this.materiel.updateMateriel(id,materiel);
    }
}
