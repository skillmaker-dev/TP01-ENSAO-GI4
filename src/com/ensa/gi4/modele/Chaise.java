package com.ensa.gi4.modele;

public class Chaise extends Materiel {
    private String type;
    private double price;

    public Chaise(int id,String name, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
