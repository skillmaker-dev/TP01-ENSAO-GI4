package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

import java.util.List;

public interface AllocationMaterielService {
    void allouerMateriel(int id, int nbreJrs);
    void rendreMateriel(int id);
    List<Materiel> listerMateriel();

}
