package controller;

import model.Polyeder;
import model.Polygon;
import model.Vektor;
import resources.GeometrieKonstanten;
import resources.Konstanten;
import resources.NummerKonstanten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 * Diese Klasse ist verantwortlich für die Berechnung geometrischer Eigenschaften von Polyedern.
 * Sie stellt Methoden zur Verfügung, um Oberfläche, Volumen und Gültigkeit eines Polyeders zu prüfen.
 *
 * @author Ziyad
 */
public class PolyederController {

    /**
     * Berechnet die gesamte Oberfläche eines gegebenen Polyeders, indem die Flächen aller Polygone summiert werden.
     *
     * @param polyeder Das Polyeder, dessen Oberfläche berechnet werden soll.
     * @return Die berechnete Oberfläche des Polyeders.
     * @precondition polyeder darf nicht null sein.
     * @postcondition Die Summe der Flächen aller Flächenelemente wird zurückgegeben.
     */
    public double berechneOberflaeche(Polyeder polyeder) {
        double oberflaeche = NummerKonstanten.DOUBLE_NULL;

        for (Polygon polygon : polyeder.getFlaechenelemente()) {
            oberflaeche += polygon.getFlaeche();
        }
        return oberflaeche;
    }

    /**
     * Überprüft, ob ein gegebenes Polyeder gültig ist, basierend auf der Euler'schen Polyederformel.
     *
     * @param polyeder Das Polyeder, das überprüft werden soll.
     * @return true, wenn das Polyeder gültig ist, andernfalls false.
     * @precondition polyeder darf nicht null sein.
     * @postcondition Das Ergebnis der Euler'schen Formel (V - E + F = 2) wird überprüft.
     */
    public boolean istGueltig(Polyeder polyeder) {
        int v = polyeder.getAnzahlEcken();
        int e = polyeder.getAnzahlKanten();
        int f = polyeder.getAnzahlFlaechen();
        return v - e + f == NummerKonstanten.ZWEI;
    }

    public ArrayList<Polygon> sortierePolyederFlaechen(Polyeder polyeder) {
        ArrayList<Polygon> sortierteListe =
                new ArrayList<>(Arrays.asList(polyeder.getFlaechenelemente()));
        Collections.sort(sortierteListe); // nutzt compareTo() nach Fläche
        return sortierteListe;
    }


    public float berechneVolumen(Polyeder polyeder) {
        VektorController vektorController = new VektorController();
        float volumen = 0f;
        for (Polygon dreieck : polyeder.getFlaechenelemente()) {
            Vektor[] eckpunkte = berechneEckpunkteAusDreieck(dreieck);
            Vektor originA = eckpunkte[NummerKonstanten.NULL];
            Vektor originB = eckpunkte[NummerKonstanten.EINS];
            Vektor originC = eckpunkte[NummerKonstanten.ZWEI];

            Vektor ab = vektorController.subtrahiere(originB, originA);
            Vektor ac = vektorController.subtrahiere(originC, originA);
            Vektor ao = vektorController.subtrahiere(GeometrieKonstanten.NULLVEKTOR, originA); // Ursprung zu A

            Vektor kreuzprodukt = vektorController.berechneKreuzprodukt(ab, ac);
            float spatprodukt = vektorController.berechneSkalarprodukt(ao, kreuzprodukt);

            volumen += spatprodukt / NummerKonstanten.SECHS;
        }
        return volumen;
    }

    /**
     * Extrahiert drei Vektoren (Eckpunkte A, B, C) aus einem gegebenen Dreieck (Polygon).
     *
     * @param dreieck Das Flächenelement (Dreieck), aus dem die Eckpunkte entnommen werden.
     * @return Ein Array aus drei Vektoren: originA, originB, originC.
     */
    private Vektor[] berechneEckpunkteAusDreieck(Polygon dreieck) {
        Vektor originA = new Vektor(
                dreieck.getKanten()[GeometrieKonstanten.ERSTE_KANTE].getEckpunktA().getXKoordinate(),
                dreieck.getKanten()[GeometrieKonstanten.ERSTE_KANTE].getEckpunktA().getYKoordinate(),
                dreieck.getKanten()[GeometrieKonstanten.ERSTE_KANTE].getEckpunktA().getZKoordinate()
        );

        Vektor originB = new Vektor(
                dreieck.getKanten()[GeometrieKonstanten.ERSTE_KANTE].getEckpunktB().getXKoordinate(),
                dreieck.getKanten()[GeometrieKonstanten.ERSTE_KANTE].getEckpunktB().getYKoordinate(),
                dreieck.getKanten()[GeometrieKonstanten.ERSTE_KANTE].getEckpunktB().getZKoordinate()
        );

        Vektor originC = new Vektor(
                dreieck.getKanten()[GeometrieKonstanten.ZWEITE_KANTE].getEckpunktB().getXKoordinate(),
                dreieck.getKanten()[GeometrieKonstanten.ZWEITE_KANTE].getEckpunktB().getYKoordinate(),
                dreieck.getKanten()[GeometrieKonstanten.ZWEITE_KANTE].getEckpunktB().getZKoordinate()
        );

        return new Vektor[]{originA, originB, originC};
    }

}

