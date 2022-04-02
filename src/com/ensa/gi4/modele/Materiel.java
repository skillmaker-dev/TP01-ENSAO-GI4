package com.ensa.gi4.modele;

public abstract class Materiel {
    protected int id;
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
