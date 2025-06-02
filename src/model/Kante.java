package model;

import controller.VektorController;
import model.Vektor;

/**
 * Repräsentiert eine Kante zwischen zwei Eckpunkten im 3D-Raum.
 * Eine Kante ist definiert durch zwei Eckpunkte A und B.
 * @author ziyad
 */
public class Kante
{

    private final Eckpunkt eckpunktA;
    private final Eckpunkt eckpunktB;

    /**
     * Konstruktor zur Initialisierung der Kante mit zwei Eckpunkten.
     * @param eckpunktA Startpunkt der Kante
     * @param eckpunktB Endpunkt der Kante
     * @throws IllegalArgumentException wenn einer der Eckpunkte null ist
     */
    public Kante(Eckpunkt eckpunktA, Eckpunkt eckpunktB)
    {
        this.eckpunktA = eckpunktA;
        this.eckpunktB = eckpunktB;
    }
    /**
     * Berechnet den Richtungsvektor der Kante von Eckpunkt B nach Eckpunkt A.
     * @return Vektor, der von Eckpunkt B zu Eckpunkt A zeigt.
     */
    public Vektor gebeVektorZurueck()
    {
        float x = eckpunktA.getXKoordinate() - eckpunktB.getXKoordinate();
        float y = eckpunktA.getYKoordinate() - eckpunktB.getYKoordinate();
        float z = eckpunktA.getZKoordinate() - eckpunktB.getZKoordinate();
        return new Vektor(x, y, z);
    }
    public Eckpunkt getEckpunktA()
    {
        return eckpunktA;
    }


    public Eckpunkt getEckpunktB()
    {
        return eckpunktB;
    }


}
