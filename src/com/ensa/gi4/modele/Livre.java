package com.ensa.gi4.modele;

public class Livre extends Materiel {
    private String author;
    private String publishYear;
    private String plot;

    public Livre(int id,String name, String author, String publishYear, String plot) {
        this.id = id;
        this.author = author;
        this.publishYear = publishYear;
        this.plot = plot;
        this.name = name;
    }


    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
