package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Materiel;

import java.util.List;

public interface IMaterielDAO {
    List<Materiel> getAllMateriels();
    void addMateriel(Materiel materiel);
    void deleteMateriel(int id);
    Materiel getMateriel(int id);
    void updateMateriel(int id, Materiel materiel);
     List<Materiel> getMaterielsAlloue();
     Materiel getFromMaterielAlloue(int id);
     void removeFromMaterielAlloue(int id);
     void addToMaterielAlloue(int id);
}
