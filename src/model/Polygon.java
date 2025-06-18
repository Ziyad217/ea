package model;

import resources.NummerKonstanten;

import java.util.Set;

/**
 * Abstrakte Klasse für Polygone, die von Polygonzug erbt.
 * Stellt sicher, dass der Polygonzug geschlossen ist.
 * Bietet abstrakte Methoden zur Berechnung von Fläche und Umfang.
 *
 * @author ziyad
 */
public abstract class Polygon extends Polygonzug implements NummerKonstanten, Comparable<Polygon>
{

    /**
     * Konstruktor für Polygon.
     *
     * @param kante Array von Kanten, die das Polygon bilden.
     * @param ecken Menge der Eckpunkte des Polygons.
     * @precondition kante und ecken dürfen nicht null sein.
     *               Der Polygonzug muss geschlossen sein.
     * @postcondition Ein Polygon-Objekt wird erzeugt.
     * @throws IllegalArgumentException wenn der Polygonzug nicht geschlossen ist.
     */
    public Polygon(Kante[] kante, Set<Eckpunkt> ecken)
    {
        super(kante, ecken);
        this.ueberpruefeObGeschlossen(this);

    }

    /**
     * Prüft, ob der Polygonzug geschlossen ist.
     *
     * Ein Polygonzug ist geschlossen, wenn der Endpunkt der letzten Kante
     * mit dem Startpunkt der ersten Kante übereinstimmt und mindestens drei Kanten besitzt.
     *
     * @param polygonzug Der zu prüfende Polygonzug.
     * @return true, wenn der Polygonzug geschlossen ist, sonst false.
     * @precondition polygonzug darf nicht null sein.
     * @postcondition Das Ergebnis gibt an, ob der Polygonzug geschlossen ist.
     */
    private boolean ueberpruefeObGeschlossen(Polygonzug polygonzug)
    {
        if (polygonzug.getKanten().length < DREI)
        {
            return false; // Ein Polygonzug mit weniger als 3 Kanten kann nicht geschlossen sein
        }

        Eckpunkt endpunktLetzteKante =
                polygonzug.getKanten()[polygonzug.getKanten().length - EINS].getEckpunktB();
        Eckpunkt startpunktErsteKante = polygonzug.getKanten()[NULL].getEckpunktA();

        return endpunktLetzteKante.equals(startpunktErsteKante);
    }

    /**
     * Abstrakte Methode zur Berechnung der Fläche des Polygons.
     *
     * @return Fläche des Polygons als double.
     */
    public abstract double getFlaeche();

    /**
     * Abstrakte Methode zur Berechnung des Umfangs des Polygons.
     *
     * @return Umfang des Polygons als float.
     */
    public abstract float getUmfang();
}
