package model;

import controller.VektorController;
import resources.NummerKonstanten;

import java.util.Set;

/**
 * Repräsentiert ein Dreieck als spezielle Form eines Polygons mit genau drei Kanten und Ecken.
 * Berechnet Fläche und Umfang des Dreiecks.
 *
 * @author ziyad
 */
public class Dreieck extends Polygon
{

    private double flaeche;
    private float umfang;

    public Dreieck(Kante[] kanten, Set<Eckpunkt> ecken) {
        super(kanten, ecken);
        this.ueberpruefeObDreieck();
    }

    @Override
    public double getFlaeche() {
        return flaeche;
    }

    @Override
    public float getUmfang() {
        return umfang;
    }

    /**
     * Prüft, ob das Polygon genau drei Kanten hat.
     * @return true, wenn genau drei Kanten vorhanden sind, sonst false.
     */
    private boolean ueberpruefeObDreieck()
    {
        return this.getKanten().length == NummerKonstanten.DREI;
    }

    @Override
    public int compareTo(Polygon o) {
        return Double.compare(this.getFlaeche(), o.getFlaeche());
    }
}
