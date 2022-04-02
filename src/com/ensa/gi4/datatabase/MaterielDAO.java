package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

import java.util.ArrayList;
import java.util.List;

public class MaterielDAO implements IMaterielDAO {

    private static MaterielDAO singleton = new MaterielDAO();
    public static MaterielDAO getInstance(){
        return singleton;
    }

    List<Materiel> materiels;
    List<Materiel> materielsAlloue;

    public MaterielDAO() {
        this.materiels = new ArrayList<>();
        this.materielsAlloue = new ArrayList<>();
        Livre livre1 = new Livre(1,"The Hunger Games","Suzanne Collins", "2011","The Hunger Games is a 2008 dystopian novel by the American writer Suzanne Collins. It is written in the perspective of 16-year-old Katniss Everdeen, who lives in the future, post-apocalyptic nation of Panem in North America.");
        Chaise chaise1 = new Chaise(2,"Ikea Chair","ArmChair",400.5);

        materiels.add(livre1);
        materiels.add(chaise1);
    }
    @Override
    public void addToMaterielAlloue(int id)
    {
        Materiel materielToAdd = null;
        for (Materiel materiel:
                materiels) {
            if (materiel.getId() == id)
            {
                materielToAdd = materiel;
                break;
            }


        }
        this.materielsAlloue.add(materielToAdd);
    }
    @Override
    public void removeFromMaterielAlloue(int id)
    {
        Materiel materielToDelete = null;
        for (Materiel materiel:
                materielsAlloue) {
            if (materiel.getId() == id)
            {
                materielToDelete = materiel;
                break;
            }


        }
        this.materielsAlloue.remove(materielToDelete);
    }
    @Override
    public Materiel getFromMaterielAlloue(int id)
    {
        Materiel materielToGet = null;
        for (Materiel materiel:
                materielsAlloue) {
            if (materiel.getId() == id)
            {
                materielToGet = materiel;
                break;
            }


        }
        return materielToGet;
    }
    @Override
    public List<Materiel> getMaterielsAlloue()
    {
        return this.materielsAlloue;
    }

    @Override
    public List<Materiel> getAllMateriels() {
        return this.materiels;
    }

    @Override
    public void addMateriel(Materiel materiel) {
        this.materiels.add(materiel);
    }

    @Override
    public void deleteMateriel(int id) {

        Materiel materielToDelete = null;
        for (Materiel materiel:
                materiels) {
            if (materiel.getId() == id)
            {
                materielToDelete = materiel;
                break;
            }


        }

        this.materiels.remove(materielToDelete);

    }

    @Override
    public Materiel getMateriel(int id) {
        Materiel materielToGet = null;
        for (Materiel materiel:
                materiels) {
            if (materiel.getId() == id)
            {
                materielToGet = materiel;
                break;
            }

        }
        return materielToGet;
    }

    @Override
    public void updateMateriel(int id, Materiel materiel) {
        Materiel materielToUpdate = null;
        for (Materiel m:
                materiels) {
            if (m.getId() == id)
            {
                materielToUpdate = m;
                break;
            }

        }
        materielToUpdate.setName(materiel.getName());
    }
}
