package controller;

import model.Eckpunkt;
import model.Vektor;

/**
 * Diese Klasse implementiert grundlegende Vektoroperationen wie Addition, Subtraktion und Kreuzprodukt.
 * Sie bietet außerdem eine Methode, um aus zwei Eckpunkten einen Vektor zu erzeugen.
 * @author Ziyad
 */
public class VektorController implements VektorMathematik
{

    /**
     * Addiert zwei gegebene Vektoren komponentenweise.
     * @param v1 Der erste Vektor.
     * @param v2 Der zweite Vektor.
     * @return Ein neuer Vektor, der die Summe der beiden Eingangsvektoren darstellt.
     * @precondition v1 und v2 dürfen nicht null sein.
     * @postcondition Ein Vektor mit addierten Komponenten wird zurückgegeben.
     */
    @Override
    public Vektor addiere(Vektor v1, Vektor v2)
    {
        return new Vektor(
                v1.getXKomponente() + v2.getXKomponente(),
                v1.getYKomponente() + v2.getYKomponente(),
                v1.getZKomponente() + v2.getZKomponente()
        );
    }

    /**
     * Subtrahiert den zweiten Vektor vom ersten Vektor komponentenweise.
     * @param v1 Der erste Vektor.
     * @param v2 Der zweite Vektor.
     * @return Ein neuer Vektor, der die Differenz der beiden Eingangsvektoren darstellt.
     * @precondition v1 und v2 dürfen nicht null sein.
     * @postcondition Ein Vektor mit subtrahierten Komponenten wird zurückgegeben.
     */
    @Override
    public Vektor subtrahiere(Vektor v1, Vektor v2)
    {
        return new Vektor(
                v1.getXKomponente() - v2.getXKomponente(),
                v1.getYKomponente() - v2.getYKomponente(),
                v1.getZKomponente() - v2.getZKomponente()
        );
    }

    /**
     * Berechnet das Kreuzprodukt zweier Vektoren.
     * @param v1 Der erste Vektor.
     * @param v2 Der zweite Vektor.
     * @return Ein neuer Vektor, der das Kreuzprodukt von v1 und v2 darstellt.
     * @precondition v1 und v2 dürfen nicht null sein.
     * @postcondition Ein Vektor orthogonal zu v1 und v2 wird zurückgegeben.
     */
    @Override
    public Vektor berechneKreuzprodukt(Vektor v1, Vektor v2)
    {
        float x = v1.getYKomponente() * v2.getZKomponente() - v1.getZKomponente() * v2.getYKomponente();
        float y = v1.getZKomponente() * v2.getXKomponente() - v1.getXKomponente() * v2.getZKomponente();
        float z = v1.getXKomponente() * v2.getYKomponente() - v1.getYKomponente() * v2.getXKomponente();
        return new Vektor(x, y, z);
    }

    @Override
    /**
     * Berechnet das Skalarprodukt (auch: Punktprodukt) zweier Vektoren.
     * @param v1 Der erste Vektor.
     * @param v2 Der zweite Vektor.
     * @return Der Skalarwert des Produkts von v1 und v2.
     * @precondition v1 und v2 dürfen nicht null sein.
     * @postcondition Ein float-Wert, der das Skalarprodukt darstellt, wird zurückgegeben.
     */
    public float berechneSkalarprodukt(Vektor v1, Vektor v2)
    {
        return v1.getXKomponente() * v2.getXKomponente()
                + v1.getYKomponente() * v2.getYKomponente()
                + v1.getZKomponente() * v2.getZKomponente();
    }

    /**
     * Erzeugt einen Vektor aus zwei gegebenen Eckpunkten, indem die Differenz ihrer Koordinaten berechnet wird.
     * @param eckpunkt1 Der erste Eckpunkt.
     * @param eckpunkt2 Der zweite Eckpunkt.
     * @return Ein neuer Vektor, der von eckpunkt2 zu eckpunkt1 zeigt.
     * @precondition eckpunkt1 und eckpunkt2 dürfen nicht null sein.
     * @postcondition Ein Vektor, der die Differenz der Koordinaten darstellt, wird zurückgegeben.
     */
    public Vektor erzeugeVektor(Eckpunkt eckpunkt1, Eckpunkt eckpunkt2)
    {
        float x = eckpunkt1.getXKoordinate() - eckpunkt2.getXKoordinate();
        float y = eckpunkt1.getYKoordinate() - eckpunkt2.getYKoordinate();
        float z = eckpunkt1.getZKoordinate() - eckpunkt2.getZKoordinate();
        return new Vektor(x, y, z);
    }
}
