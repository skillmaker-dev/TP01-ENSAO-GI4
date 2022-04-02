package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;

public class AllocationMaterielServiceImpl implements AllocationMaterielService {

    private MaterielDAO materiel;
    private MaterielDAO materielPrototype;


    public void setMaterielDao(MaterielDAO materiel) {
        // injection par accesseur
        this.materiel = materiel;
    }

    public void setMaterielDaoPrototype(MaterielDAO materiel) {
        // injection par accesseur
        this.materielPrototype = materiel;
    }

    @Override
    public void allouerMateriel(int id, int nbreJrs) {
        this.materiel.deleteMateriel(id);
        String data = "Materiel Alloué pour " + nbreJrs + " Jours";
    }

    @Override
    public void rendreMateriel(int id) {
       Materiel m =  this.materielPrototype.getMateriel(id);
       this.materiel.addMateriel(m);
    }


}
