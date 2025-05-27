package model;

import resources.NummerKonstanten;

import java.util.Set;

public abstract class Polygon extends Polygonzug{
    private float area;
    public Polygon(Kante[] kante, Set<Eckpunkt> ecken) {
        super(kante, ecken);
        this.ueberpruefeObGeschlossen(this);
    }

    public abstract double berechneFlaeche();

    private boolean ueberpruefeObGeschlossen (Polygonzug polygonzug) {
        if (polygonzug.getKanten().length < NummerKonstanten.DREI) {
            return false; // Ein Polygonzug mit weniger als 2 Kanten kann nicht geschlossen sein
        }
        Eckpunkt endpunktLetzteKante =
                polygonzug.getKanten()[polygonzug.getKanten().length - NummerKonstanten.EINS].getEckpunktB();
        Eckpunkt startpunktErsteKante = polygonzug.getKanten()[NummerKonstanten.NULL].getEckpunktA();

        return endpunktLetzteKante.equals(startpunktErsteKante);

    }
    public abstract float berechneUmfang();



}
