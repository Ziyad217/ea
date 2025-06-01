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
public class Polyeder implements NummerKonstanten {

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
    }

    /**
     * Liefert alle eindeutigen Eckpunkte des Polyeders.
     *
     * @return Menge aller Eckpunkte als Set<Eckpunkt>.
     * @precondition Keine.
     * @postcondition Gibt ein Set zurück, das alle Eckpunkte aller Flächen enthält.
     */
    public Set<Eckpunkt> getAlleEcken()
    {
        Set<Eckpunkt> alleEcken = new HashSet<>();
        for (Polygon polygon : flaechenelemente)
        {
            alleEcken.addAll(polygon.getEcken());
        }
        return alleEcken;
    }

    /**
     * Liefert alle Kanten des Polyeders als Array.
     * Kanten können mehrfach vorkommen, wenn sie mehrere Flächen teilen.
     *
     * @return Array aller Kanten im Polyeder.
     * @precondition Keine.
     * @postcondition Gibt ein Array mit allen Kanten aller Flächen zurück.
     */
    public Kante[] getAlleKanten()
    {
        List<Kante> alleKanten = new ArrayList<>();
        for (Polygon polygon : flaechenelemente)
        {
            alleKanten.addAll(Arrays.asList(polygon.getKanten()));
        }
        return alleKanten.toArray(new Kante[0]);
    }

    /**
     * Liefert die Anzahl der eindeutigen Eckpunkte des Polyeders.
     *
     * @return Anzahl der Eckpunkte.
     * @precondition Keine.
     * @postcondition Gibt die Anzahl der eindeutigen Eckpunkte zurück.
     */
    public int getAnzahlEcken()
    {
        return getAlleEcken().size();
    }

    /**
     * Liefert die Anzahl der Kanten im Polyeder.
     * Kanten werden nicht auf Duplikate geprüft.
     *
     * @return Anzahl der Kanten.
     * @precondition Keine.
     * @postcondition Gibt die Gesamtanzahl der Kanten zurück.
     */
    public int getAnzahlKanten()
    {
        return getAlleKanten().length;
    }

    /**
     * Liefert die Anzahl der Flächen des Polyeders.
     *
     * @return Anzahl der Flächen.
     * @precondition Keine.
     * @postcondition Gibt die Anzahl der Flächen zurück.
     */
    public int getAnzahlFlaechen()
    {
        return flaechenelemente.length;
    }

    /**
     * Liefert alle Flächenelemente (Polygone) des Polyeders.
     *
     * @return Array der Flächenelemente.
     * @precondition Keine.
     * @postcondition Gibt das Array der Flächen zurück.
     */
    public Polygon[] getFlaechenelemente()
    {
        return flaechenelemente;
    }
}
