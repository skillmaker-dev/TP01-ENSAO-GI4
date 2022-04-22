package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

import java.util.List;

public interface GestionMaterielService {
    void init();

    void getAllMateriels();
    void addMateriel();
    void deleteMateriel();
    void getMateriel(int id);
    void updateMateriel();
}
