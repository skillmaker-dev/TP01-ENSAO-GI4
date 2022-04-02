package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;

import java.util.List;

public class AllocationMaterielServiceImpl implements AllocationMaterielService {

    private MaterielDAO materiel;



    public void setMaterielDao(MaterielDAO materiel) {
        // injection par accesseur
        this.materiel = materiel;
    }


    @Override
    public void allouerMateriel(int id, int nbreJrs) {
        this.materiel.addToMaterielAlloue(id);
        this.materiel.deleteMateriel(id);
        String data = "Materiel Alloué pour " + nbreJrs + " Jours";
        System.out.println(data);
    }

    @Override
    public void rendreMateriel(int id) {
       Materiel m =  this.materiel.getFromMaterielAlloue(id);
       this.materiel.removeFromMaterielAlloue(id);
       this.materiel.addMateriel(m);
    }

    @Override
    public List<Materiel> listerMateriel() {
        return materiel.getMaterielsAlloue();
    }


}
