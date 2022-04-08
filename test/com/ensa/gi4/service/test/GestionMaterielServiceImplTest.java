package com.ensa.gi4.service.test;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.impl.GestionMaterielServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//pas encore terminée

public class GestionMaterielServiceImplTest {

    private GestionMaterielService gestionMaterielService;
    private List<Materiel> materiels;

    //injection par constructeur
    public GestionMaterielServiceImplTest(GestionMaterielService gestionMaterielService) {
        this.gestionMaterielService = gestionMaterielService;
    }

    @Before
    public void setUp() throws Exception {
        materiels = new ArrayList<Materiel>();
        materiels.add(new Livre(1,"The Hunger Games","Suzanne Collins", "2011","The Hunger Games is a 2008 dystopian novel by the American writer Suzanne Collins. It is written in the perspective of 16-year-old Katniss Everdeen, who lives in the future, post-apocalyptic nation of Panem in North America."));
        materiels.add(new Chaise(2,"Ikea Chair","ArmChair",400.5));
    }

    @After
    public void tearDown() throws Exception {
        gestionMaterielService = null;
        materiels = null;
    }

    @Test
    public void getAllMateriels() {
        assertEquals(materiels,gestionMaterielService.getAllMateriels());
    }
}