package controller;

import model.Eckpunkt;
import model.Polyeder;
import model.Polygon;
import resources.NummerKonstanten;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse ist verantwortlich für die Berechnung geometrischer Eigenschaften von Polyedern.
 * Sie stellt Methoden zur Verfügung, um Oberfläche, Volumen und Gültigkeit eines Polyeders zu prüfen.
 * @author Ziyad
 */
public class PolyederController
{

    /**
     * Berechnet die gesamte Oberfläche eines gegebenen Polyeders, indem die Flächen aller Polygone summiert werden.
     * @param polyeder Das Polyeder, dessen Oberfläche berechnet werden soll.
     * @return Die berechnete Oberfläche des Polyeders.
     * @precondition polyeder darf nicht null sein.
     * @postcondition Die Summe der Flächen aller Flächenelemente wird zurückgegeben.
     */
    public double berechneOberflaeche(Polyeder polyeder)
    {
        double oberflaeche = NummerKonstanten.DOUBLE_NULL;

        for (Polygon polygon : polyeder.getFlaechenelemente()) {
            oberflaeche += polygon.berechneFlaeche();
        }
        return oberflaeche;
    }

    /**
     * Überprüft, ob ein gegebenes Polyeder gültig ist, basierend auf der Euler'schen Polyederformel.
     * @param polyeder Das Polyeder, das überprüft werden soll.
     * @return true, wenn das Polyeder gültig ist, andernfalls false.
     * @precondition polyeder darf nicht null sein.
     * @postcondition Das Ergebnis der Euler'schen Formel (V - E + F = 2) wird überprüft.
     */
    public boolean istGueltig(Polyeder polyeder)
    {
        int v = polyeder.getAnzahlEcken();
        int e = polyeder.getAnzahlKanten();
        int f = polyeder.getAnzahlFlaechen();
        return v - e + f == NummerKonstanten.ZWEI;
    }


    public double berechneVolumen(Polyeder polyeder)
    {
        return 0.0;
    }
}

