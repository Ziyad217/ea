package controller;

import model.Vektor;

/**
 * Dieses Interface definiert grundlegende Vektoroperationen,
 * die von einer Implementierung bereitgestellt werden müssen.
 *
 * @author ziyad
 */
public interface VektorMathematik
{

    /**
     * Addiert zwei Vektoren komponentenweise.
     *
     * @param v1 Der erste Vektor.
     * @param v2 Der zweite Vektor.
     * @return Ein neuer Vektor, der die Summe von v1 und v2 darstellt.
     */
    Vektor addiere(Vektor v1, Vektor v2);

    /**
     * Subtrahiert den zweiten Vektor vom ersten Vektor komponentenweise.
     *
     * @param v1 Der erste Vektor.
     * @param v2 Der zweite Vektor.
     * @return Ein neuer Vektor, der die Differenz von v1 und v2 darstellt.
     */
    Vektor subtrahiere(Vektor v1, Vektor v2);

    /**
     * Berechnet das Kreuzprodukt zweier Vektoren.
     *
     * @param v1 Der erste Vektor.
     * @param v2 Der zweite Vektor.
     * @return Ein neuer Vektor, der das Kreuzprodukt von v1 und v2 darstellt.
     */
    Vektor berechneKreuzprodukt(Vektor v1, Vektor v2);

    float berechneSkalarprodukt(Vektor v1, Vektor v2);
}
