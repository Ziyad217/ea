package model;

import resources.NummerKonstanten;

import java.util.*;

public class Polyeder {
    private Polygon[] flaechenelemente;

    public Set<Eckpunkt> getAlleEcken(){
            Set<Eckpunkt> alleEcken = new HashSet<>();

            for (Polygon polygon : flaechenelemente) {
                alleEcken.addAll(polygon.getEcken());
            }

            return alleEcken;
    }

    public Kante[] getAlleKanten() {
        List<Kante> alleKanten = new ArrayList<>();

        for (Polygon polygon : flaechenelemente) {
            alleKanten.addAll(Arrays.asList(polygon.getKanten()));
        }

        return alleKanten.toArray(new Kante[alleKanten.size()]);
    }

    public int getAnzahlEcken() {
        return getAlleEcken().size();
    }

    public int getAnzahlKanten() {
        return getAlleKanten().length;
    }

    public int getAnzahlFlaechen() {
        return flaechenelemente.length;
    }

    public Polygon[] getFlaechenelemente() {
        return flaechenelemente;
    }

    public boolean istGueltig() {
        // Euler'sche Polyederformel (V - E + F = 2) für konvexe Polyeder
        int v = getAnzahlEcken();
        int e = getAnzahlKanten();
        int f = getAnzahlFlaechen();
        return v - e + f == NummerKonstanten.ZWEI;
    }


    public double berechneVolumen() {
        double volumen = 0.0;

        // Ursprung als Fixpunkt für Tetraeder
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;

        for (Polygon polygon : flaechenelemente) {
            // Annahme: polygon hat genau 3 Eckpunkte (Dreieck)
            List<Eckpunkt> ecken = new ArrayList<>(polygon.getEcken());
            if (ecken.size() != 3) {
                throw new IllegalArgumentException("Alle Flächen müssen Dreiecke sein!");
            }

            Eckpunkt punkt1 = ecken.get(0);
            Eckpunkt punkt2 = ecken.get(1);
            Eckpunkt punkt3 = ecken.get(2);

            // Vektoren von Ursprung zu punkt1, punkt2, punkt3
            double ax = punkt1.getXKoordinate() - ox;
            double ay = punkt1.getYKoordinate() - oy;
            double az = punkt1.getZKoordinate() - oz;

            double bx = punkt2.getXKoordinate() - ox;
            double by = punkt2.getYKoordinate() - oy;
            double bz = punkt2.getZKoordinate() - oz;

            double cx = punkt3.getXKoordinate() - ox;
            double cy = punkt3.getYKoordinate() - oy;
            double cz = punkt3.getZKoordinate() - oz;

            // Kreuzprodukt b x c
            double kreuzX = by * cz - bz * cy;
            double kreuzY = bz * cx - bx * cz;
            double kreuzZ = bx * cy - by * cx;

            // Skalarprodukt a · (b x c)
            double skalarTriple = ax * kreuzX + ay * kreuzY + az * kreuzZ;

            // Volumen Tetraeder = |skalarTriple| / 6
            volumen += skalarTriple;
        }

        volumen = Math.abs(volumen) / 6.0;
        return volumen;
    }
}
