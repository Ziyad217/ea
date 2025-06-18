package model;

import resources.NummerKonstanten;

import java.util.*;

/**
 * Diese Klasse repräsentiert ein Polyeder, das aus mehreren Polygon-Flächenelementen besteht.
 * Sie bietet Methoden zum Zugriff auf die Eckpunkte, Kanten und Flächen des Polyeders
 * sowie eine Validierungsmethode basierend auf der Euler'schen Polyederformel.
 *
 * @author ziyad
 */
public class Polyeder implements NummerKonstanten
{

    private Polygon[] flaechenelemente;

    /**
     * Konstruktor für ein Polyeder.
     *
     * @param flaechenelemente Array von Polygon-Flächenelementen, die das Polyeder bilden.
     * @precondition flaechenelemente darf nicht null sein und mindestens eine Fläche enthalten.
     * @postcondition Ein Polyeder-Objekt wird erzeugt und gespeichert.
     */
    public Polyeder(Polygon[] flaechenelemente)
    {
        this.flaechenelemente = flaechenelemente;
        istGueltig(this);
    }

    private boolean istGueltig(Polyeder polyeder)
    {
        int v = polyeder.getAnzahlEcken();
        int e = polyeder.getAnzahlKanten();
        int f = polyeder.getAnzahlFlaechen();
        return v - e + f == NummerKonstanten.ZWEI;
    }

    public Set<Eckpunkt> getAlleEcken()
    {
        Set<Eckpunkt> alleEcken = new HashSet<>();
        for (Polygon polygon : flaechenelemente)
        {
            alleEcken.addAll(polygon.getEcken());
        }
        return alleEcken;
    }


    public Kante[] getAlleKanten()
    {
        List<Kante> alleKanten = new ArrayList<>();
        for (Polygon polygon : flaechenelemente)
        {
            alleKanten.addAll(Arrays.asList(polygon.getKanten()));
        }
        return alleKanten.toArray(new Kante[0]);
    }


    public int getAnzahlEcken()
    {
        return getAlleEcken().size();
    }

    public int getAnzahlKanten()
    {
        return getAlleKanten().length;
    }


    public int getAnzahlFlaechen()
    {
        return flaechenelemente.length;
    }


    public Polygon[] getFlaechenelemente()
    {
        return flaechenelemente;
    }
}
