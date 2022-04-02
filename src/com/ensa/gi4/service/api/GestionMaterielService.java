package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

import java.util.List;

public interface GestionMaterielService {
    void init();

    List<Materiel> getAllMateriels();
    void addMateriel(Materiel materiel);
    void deleteMateriel(int id);
    Materiel getMateriel(int id);
    void updateMateriel(int id, Materiel materiel);
}
